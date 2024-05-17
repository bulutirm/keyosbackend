package com.example.keyos.service.Impl;

import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.repository.EtkinlikTalepFormuRepository;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtkinlikTalepFormuServiceImpl implements EtkinlikTalepFormuService {

    private final EtkinlikTalepFormuRepository etkinlikTalepFormuRepository;

    public EtkinlikTalepFormuServiceImpl(EtkinlikTalepFormuRepository etkinlikTalepFormuRepository) {
        this.etkinlikTalepFormuRepository = etkinlikTalepFormuRepository;
    }

    @Override
    public List<EtkinlikTalepFormu> getEtkinlikTalepFormu() {
        List<EtkinlikTalepFormu> etkinlikTalepFormuList = etkinlikTalepFormuRepository.findAll();
        return etkinlikTalepFormuList;
    }

    @Override
    public void save(EtkinlikTalepFormu etkinlikTalepFormu) {
        etkinlikTalepFormuRepository.save(etkinlikTalepFormu);
    }
}
