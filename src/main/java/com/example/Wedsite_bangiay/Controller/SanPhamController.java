package com.example.Wedsite_bangiay.Controller;

import com.example.Wedsite_bangiay.model.GioHang;
import com.example.Wedsite_bangiay.model.SanPham;
import com.example.Wedsite_bangiay.service.DanhMucService;
import com.example.Wedsite_bangiay.service.GioHangService;
import com.example.Wedsite_bangiay.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // Hiển thị giỏ hàng
    @GetMapping("/gio-hang")
    public String giohang(Model model) {
        Long userId = 1L;  // Giả sử bạn lấy userId từ session hoặc từ thông tin đăng nhập của người dùng
        List<GioHang> listGioHang = gioHangService.getGioHangByUserId(userId);  // Lấy giỏ hàng của người dùng theo userId
        model.addAttribute("listGioHang", listGioHang);  // Gửi giỏ hàng đến view
        return "giohang";  // Tên view giỏ hàng
    }
    @GetMapping("lien-he")
    public String lienhe(Model model) {
        return "lienhe";
    }
}
