package com.example.Wedsite_bangiay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "acc_khachhang")
public class AccKhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // Ánh xạ quan hệ một-nhiều với GioHang
    @OneToMany(mappedBy = "accKhachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GioHang> gioHangs; // Đảm bảo rằng quan hệ này là đúng
}
