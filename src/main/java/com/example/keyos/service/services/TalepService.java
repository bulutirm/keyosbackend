package com.example.keyos.service.services;

import com.example.keyos.model.Talep;

import java.util.List;

public interface TalepService {

    List<Talep> getAll();
    void save(Talep talep);
}
