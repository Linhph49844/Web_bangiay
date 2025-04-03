package com.example.Wedsite_bangiay.repository;

import com.example.Wedsite_bangiay.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GioHangRepository extends JpaRepository<GioHang, Long> {
    List<GioHang> findByUserId(Long userId);  // Lấy giỏ hàng theo ID người dùng
}
