package com.example.keyos.repository;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.Kulup;
import com.example.keyos.model.OnayDurumu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtkinlikRepository extends JpaRepository<Etkinlik, Long> {

    @Query("SELECT e FROM Etkinlik e WHERE e.kulup = :kulup")
    List<Etkinlik> findEtkinlikByKulup(@Param("kulup") Kulup kulup);

    @Query("SELECT e.onayDurumu FROM Etkinlik e WHERE e.id = :etkinlikId")
    OnayDurumu findOnayDurumuByEtkinlikId(@Param("etkinlikId") Long etkinlikId);

}
