package com.example.Wedsite_bangiay.service;

import com.example.Wedsite_bangiay.model.GioHang;
import com.example.Wedsite_bangiay.repository.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;

    // Lấy giỏ hàng theo userId
    public List<GioHang> getGioHangByUserId(Long userId) {
        return gioHangRepository.findByAccKhachHangId(userId);  // Giả sử repository có phương thức này
    }

}
