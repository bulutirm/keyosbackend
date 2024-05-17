package com.example.keyos.repository;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Kulup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KulupRepository extends JpaRepository<Kulup, Long> {

    @Query("SELECT k FROM Kulup k WHERE k.danismanAkademisyen = :danismanAkademisyen")
    List<Kulup> findKulupByDanismanAkademisyen(@Param("danismanAkademisyen") DanismanAkademisyen danismanAkademisyen);
}
