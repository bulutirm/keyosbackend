package com.example.keyos.service.services;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.KulupBaskan;
import com.example.keyos.model.Talep;

import java.util.List;

public interface KulupBaskanService {

    List<KulupBaskan> getAll();
    KulupBaskan getById(Long id);
    void save(KulupBaskan kulupBaskan);
    void createEtkinlikTalepFormu(KulupBaskan kulupBaskan, Etkinlik etkinlik, Talep talep);
    void changePassword(KulupBaskan kulupBaskan, String Password);
}
