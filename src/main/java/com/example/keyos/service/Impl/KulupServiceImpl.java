package com.example.keyos.service.Impl;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Kulup;
import com.example.keyos.repository.KulupRepository;
import com.example.keyos.service.services.KulupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KulupServiceImpl implements KulupService {

    private final KulupRepository kulupRepository;

    public KulupServiceImpl(KulupRepository kulupRepository) {
        this.kulupRepository = kulupRepository;
    }

    @Override
    public void save(Kulup kulup) {
        kulupRepository.save(kulup);
    }

    @Override
    public List<Kulup> getKulupByDanisman(DanismanAkademisyen danismanAkademisyen) {
        List<Kulup> kulupList = kulupRepository.findKulupByDanismanAkademisyen(danismanAkademisyen);
        return kulupList;
    }
}
