package com.example.keyos.service.Impl;

import com.example.keyos.model.EtkinlikTakvimi;
import com.example.keyos.repository.EtkinlikTakvimiRepository;
import com.example.keyos.service.services.EtkinlikTakvimiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtlinlikTakvimiServiceImpl implements EtkinlikTakvimiService {

    private final EtkinlikTakvimiRepository etkinlikTakvimiRepository;

    public EtlinlikTakvimiServiceImpl(EtkinlikTakvimiRepository etkinlikTakvimiRepository) {
        this.etkinlikTakvimiRepository = etkinlikTakvimiRepository;
    }

    @Override
    public List<EtkinlikTakvimi> getAll() {
        List<EtkinlikTakvimi> etkinlikTakvimiList = etkinlikTakvimiRepository.findAll();
        return etkinlikTakvimiList;
    }

    @Override
    public void save(EtkinlikTakvimi etkinlikTakvimi) {
        etkinlikTakvimiRepository.save(etkinlikTakvimi);
    }
}
