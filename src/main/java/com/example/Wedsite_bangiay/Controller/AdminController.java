package com.example.Wedsite_bangiay.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quanli")
public class AdminController {

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        return "admin";
    }
    @GetMapping("nhan-vien")
    public String nhanvien(Model model) {
        return "quanlinhanvien";
    }
    @GetMapping("khach-hang")
    public String khachhang(Model model) {
        return "quanlikhachhang";
    }
    @GetMapping("doanh-thu")
    public String doanhthu(Model model) {
        return "doanhthu";
    }
}
