package com.example.keyos.service.services;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.Kulup;
import com.example.keyos.model.OnayDurumu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DanismanAkedemisyenService {

    List<DanismanAkademisyen> getAll();
    DanismanAkademisyen getById(Long id);
    void save(DanismanAkademisyen danismanAkademisyen);
    void setOnay(DanismanAkademisyen danismanAkademisyen, Etkinlik etkinlik, Boolean onay);
    void setPassword(DanismanAkademisyen danismanAkademisyen, String password);

}
