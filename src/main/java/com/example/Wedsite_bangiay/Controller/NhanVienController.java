package com.example.Wedsite_bangiay.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("nhanvien")
public class NhanVienController {
    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        return "nhanvien";
    }
    @GetMapping("don-hang")
    public String xacnhan(Model model) {
        return "xacnhandonhang";
    }
    @GetMapping("hang-ton")
    public String khohang(Model model) {
        return "khohang";
    }
}
