package com.example.keyos.service.Impl;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.Kulup;
import com.example.keyos.repository.DanismanAkademisyenRepository;
import com.example.keyos.service.services.DanismanAkedemisyenService;
import com.example.keyos.service.services.EtkinlikService;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.KulupService;

import java.util.List;

public class DanismanAkademisyenServiceImpl implements DanismanAkedemisyenService{

    private final DanismanAkademisyenRepository danismanAkademisyenRepository;
    private final KulupService kulupService;
    private final EtkinlikService etkinlikService;
    private final EtkinlikTalepFormuService etkinlikTalepFormuService;

    public DanismanAkademisyenServiceImpl(DanismanAkademisyenRepository danismanAkademisyenRepository, KulupService kulupService, EtkinlikService etkinlikService, EtkinlikTalepFormuService etkinlikTalepFormuService) {
        this.danismanAkademisyenRepository = danismanAkademisyenRepository;
        this.kulupService = kulupService;
        this.etkinlikService = etkinlikService;
        this.etkinlikTalepFormuService = etkinlikTalepFormuService;
    }


    @Override
    public List<DanismanAkademisyen> getAll() {
        List<DanismanAkademisyen> danismanAkademisyenList = danismanAkademisyenRepository.findAll();
        return danismanAkademisyenList;
    }

    @Override
    public DanismanAkademisyen getById(Long id) {
        return danismanAkademisyenRepository.getById(id);
    }

    @Override
    public void save(DanismanAkademisyen danismanAkademisyen) {
        danismanAkademisyenRepository.save(danismanAkademisyen);
    }

    @Override
    public void setOnay(DanismanAkademisyen danismanAkademisyen, Etkinlik etkinlik, Boolean onay) {
        if(onay.equals(true)){
            etkinlik.getOnayDurumu().setOnayDanismanAkademisyen(true);
        } else if (onay.equals(false)) {
            etkinlik.getOnayDurumu().setOnayDanismanAkademisyen(false);
        }
    }

    @Override
    public void setPassword(DanismanAkademisyen danismanAkademisyen, String password) {
        danismanAkademisyen.setSifre(password);
        save(danismanAkademisyen);
    }


}
