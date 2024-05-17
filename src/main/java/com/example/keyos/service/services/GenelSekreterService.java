package com.example.keyos.service.services;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.GenelSekreter;

import java.util.List;

public interface GenelSekreterService {

    List<GenelSekreter> getAll();
    GenelSekreter getById(Long id);
    void save(GenelSekreter genelSekreter);
    void setOnay(GenelSekreter genelSekreter, EtkinlikTalepFormu etkinlikTalepFormu, Boolean onay);
    void changePassword(GenelSekreter genelSekreter, String password);
}
