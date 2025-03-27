package com.example.Wedsite_bangiay.service;

import com.example.Wedsite_bangiay.model.SanPham;
import com.example.Wedsite_bangiay.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    // Lấy tất cả sản phẩm
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Optional<SanPham> getSanPhamById(Long id) {
        return sanPhamRepository.findById(id);
    }

    // Lấy sản phẩm theo danh mục
    public List<SanPham> getSanPhamByDanhMuc(Long danhMucId) {
        return sanPhamRepository.findByDanhMucId(danhMucId); // Truy vấn sản phẩm theo danh mục
    }
    public List<SanPham> searchSanPham(String query) {
        return sanPhamRepository.findByNameContainingIgnoreCase(query); // Tìm sản phẩm theo tên
    }
}
