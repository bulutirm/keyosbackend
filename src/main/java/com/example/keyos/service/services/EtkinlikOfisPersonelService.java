package com.example.keyos.service.services;

import com.example.keyos.model.*;

import java.util.List;

public interface EtkinlikOfisPersonelService {

    List<EtkinlikOfisPersonel> getAll();
    EtkinlikOfisPersonel getById(Long id);
    void save(EtkinlikOfisPersonel etkinlikOfisPersonel);
    void setOnay(EtkinlikOfisPersonel etkinlikOfisPersonel, EtkinlikTalepFormu etkinlikTalepFormu, Boolean onay);

    void addKulupAndKulupBaskan(Kulup kulup, KulupBaskan kulupBaskan);
    void changePassword(EtkinlikOfisPersonel etkinlikOfisPersonel, String password);
}
