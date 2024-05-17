package com.example.keyos.service.services;

import com.example.keyos.model.EtkinlikTakvimi;

import java.util.List;

public interface EtkinlikTakvimiService {

    List<EtkinlikTakvimi> getAll();
    void save(EtkinlikTakvimi etkinlikTakvimi);
}
