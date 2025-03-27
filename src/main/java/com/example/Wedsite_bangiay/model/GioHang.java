package com.example.Wedsite_bangiay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "giohang")
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ánh xạ với sản phẩm
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AccKhachHang accKhachHang; // Đảm bảo ánh xạ đúng với AccKhachHang

    @Column(name = "quantity")
    private Integer quantity;
}
