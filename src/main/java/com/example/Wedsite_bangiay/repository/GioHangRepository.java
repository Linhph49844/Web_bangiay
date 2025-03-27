package com.example.Wedsite_bangiay.repository;

import com.example.Wedsite_bangiay.model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {

    // Lấy giỏ hàng của người dùng theo userId
    List<GioHang> findByAccKhachHangId(Long userId); // Sử dụng AccKhachHangId
}
