package com.example.Wedsite_bangiay.Controller;

import com.example.Wedsite_bangiay.model.GioHang;
import com.example.Wedsite_bangiay.model.SanPham;
import com.example.Wedsite_bangiay.service.DanhMucService;
import com.example.Wedsite_bangiay.service.GioHangService;
import com.example.Wedsite_bangiay.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DanhMucService danhMucService;

    @Autowired
    private GioHangService gioHangService; // Inject GioHangService

    @GetMapping("/hien-thi")
    public String trangchu(Model model) {
        return "hienthi";  // Tên view
    }

    // Hiển thị tất cả sản phẩm
    @GetMapping("/san-pham")
    public String sanpham(Model model) {
        model.addAttribute("listSanPham", sanPhamService.getAllSanPham());
        model.addAttribute("listDanhMuc", danhMucService.getAllDanhMuc());
        model.addAttribute("sanPham", new SanPham());
        return "sanpham";  // Tên view
    }

    // Hiển thị sản phẩm theo danh mục
    @GetMapping("/danhmuc/{id}")
    public String sanPhamTheoDanhMuc(@PathVariable("id") Long idDanhMuc, Model model) {
        model.addAttribute("listSanPham", sanPhamService.getSanPhamByDanhMuc(idDanhMuc));  // Lấy sản phẩm theo danh mục
        model.addAttribute("listDanhMuc", danhMucService.getAllDanhMuc());  // Lấy danh sách danh mục
        return "sanpham";  // Tên view
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/search")
    public String searchSanPham(@RequestParam("query") String query, Model model) {
        model.addAttribute("listSanPham", sanPhamService.searchSanPham(query));
        return "sanpham"; // Hiển thị kết quả tìm kiếm
    }

    // Hiển thị giỏ hàng của người dùng
    @GetMapping("/gio-hang")
    public String hienThiGioHang(@RequestParam("userId") Long userId, Model model) {
        List<GioHang> gioHangs = gioHangService.getGioHangByUserId(userId);  // Lấy giỏ hàng của người dùng
        model.addAttribute("gioHangs", gioHangs);  // Thêm giỏ hàng vào model để hiển thị
        model.addAttribute("userId", userId);  // Thêm userId để truyền lại khi cập nhật số lượng hoặc xóa sản phẩm
        return "giohang";  // Tên view giỏ hàng
    }

    // Xóa sản phẩm khỏi giỏ hàng
    @GetMapping("/gio-hang/xoa/{gioHangId}")
    public String xoaSanPham(@PathVariable Long gioHangId, @RequestParam("userId") Long userId) {
        gioHangService.xoaSanPhamFromGioHang(gioHangId);  // Xóa sản phẩm khỏi giỏ hàng
        return "redirect:/sanpham/gio-hang?userId=" + userId;  // Quay lại giỏ hàng của người dùng
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    @PostMapping("/gio-hang/cap-nhat/{gioHangId}")
    public String capNhatSoLuong(@PathVariable Long gioHangId, @RequestParam("quantity") int quantity, @RequestParam("userId") Long userId) {
        gioHangService.capNhatSoLuong(gioHangId, quantity);  // Cập nhật số lượng sản phẩm trong giỏ hàng
        return "redirect:/sanpham/gio-hang?userId=" + userId;  // Quay lại giỏ hàng của người dùng
    }

    @GetMapping("lien-he")
    public String lienhe(Model model) {
        return "lienhe";
    }
}
