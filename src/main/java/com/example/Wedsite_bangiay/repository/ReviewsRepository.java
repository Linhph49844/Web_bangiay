package com.example.Wedsite_bangiay.repository;

import com.example.Wedsite_bangiay.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findBySanPham_Id(Long productId);
}
