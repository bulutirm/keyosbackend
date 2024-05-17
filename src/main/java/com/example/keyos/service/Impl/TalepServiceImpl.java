package com.example.keyos.service.Impl;

import com.example.keyos.model.Talep;
import com.example.keyos.repository.TalepRepository;
import com.example.keyos.service.services.TalepService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalepServiceImpl implements TalepService {

    private final TalepRepository talepRepository;

    public TalepServiceImpl(TalepRepository talepRepository) {
        this.talepRepository = talepRepository;
    }

    @Override
    public List<Talep> getAll() {
        List<Talep> talepList = talepRepository.findAll();
        return talepList;
    }

    @Override
    public void save(Talep talep) {
        talepRepository.save(talep);
    }
}
