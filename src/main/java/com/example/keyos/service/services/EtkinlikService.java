package com.example.keyos.service.services;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.Kulup;
import com.example.keyos.model.OnayDurumu;

import java.util.List;

public interface EtkinlikService {

    List<Etkinlik> getAll();
    Etkinlik getById(Long id);
    void save(Etkinlik etkinlik);
    List<Etkinlik> getEtkinlikByKulup(Kulup kulup);
    OnayDurumu getOnayDurumuByEtkinlikId(Long etkinlikId);
    void controlEtkinlikOnayDurum();
}
