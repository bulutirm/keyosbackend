package com.example.keyos.service.Impl;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.GenelSekreter;
import com.example.keyos.repository.GenelSekreterRepository;
import com.example.keyos.service.services.EtkinlikService;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.GenelSekreterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenelSekreterServiceImpl implements GenelSekreterService {

    private final GenelSekreterRepository genelSekreterRepository;
    private final EtkinlikService etkinlikService;
    private final EtkinlikTalepFormuService etkinlikTalepFormuService;

    public GenelSekreterServiceImpl(GenelSekreterRepository genelSekreterRepository, EtkinlikService etkinlikService, EtkinlikTalepFormuService etkinlikTalepFormuService) {
        this.genelSekreterRepository = genelSekreterRepository;
        this.etkinlikService = etkinlikService;
        this.etkinlikTalepFormuService = etkinlikTalepFormuService;
    }

    @Override
    public List<GenelSekreter> getAll() {
        List<GenelSekreter> genelSekreterList = genelSekreterRepository.findAll();
        return genelSekreterList;
    }

    @Override
    public GenelSekreter getById(Long id) {
        return genelSekreterRepository.getReferenceById(id);
    }

    @Override
    public void save(GenelSekreter genelSekreter) {
        genelSekreterRepository.save(genelSekreter);
    }

    @Override
    public void setOnay(GenelSekreter genelSekreter, EtkinlikTalepFormu etkinlikTalepFormu, Boolean onay) {
        List<EtkinlikTalepFormu> etkinlikTalepFormuList = etkinlikTalepFormuService.getEtkinlikTalepFormu();
        for(EtkinlikTalepFormu etkinlikTalepFormu1 : etkinlikTalepFormuList){
            if(etkinlikTalepFormu1.equals(etkinlikTalepFormu)){
                if(onay.equals(true)){
                    etkinlikTalepFormu1.getEtkinlik().getOnayDurumu().setOnayGenelSekreter(true);
                }else if(onay.equals(false)){
                    etkinlikTalepFormu1.getEtkinlik().getOnayDurumu().setOnayGenelSekreter(false);
                }
            }
        }
    }

    @Override
    public void changePassword(GenelSekreter genelSekreter, String password) {
        genelSekreter.setSifre(password);
        save(genelSekreter);
    }
}
