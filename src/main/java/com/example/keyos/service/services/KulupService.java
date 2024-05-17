package com.example.keyos.service.services;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Kulup;

import java.util.List;

public interface KulupService {

    void save(Kulup kulup);
    List<Kulup> getKulupByDanisman(DanismanAkademisyen danismanAkademisyen);
}
