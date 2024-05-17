package com.example.keyos.service.services;

import com.example.keyos.model.EtkinlikTalepFormu;

import java.util.List;

public interface EtkinlikTalepFormuService {

    List<EtkinlikTalepFormu> getEtkinlikTalepFormu();
    void save(EtkinlikTalepFormu etkinlikTalepFormu);
}
