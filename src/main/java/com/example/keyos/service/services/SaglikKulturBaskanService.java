package com.example.keyos.service.services;

import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.SaglikKulturBaskani;

import java.util.List;

public interface SaglikKulturBaskanService {

    List<SaglikKulturBaskani> getAll();
    SaglikKulturBaskani getById(Long id);
    void save(SaglikKulturBaskani saglikKulturBaskani);
    void setOnay(SaglikKulturBaskani saglikKulturBaskani, EtkinlikTalepFormu etkinlikTalepFormu, Boolean onay);
    void changePassword(SaglikKulturBaskani saglikKulturBaskani, String password);
}

