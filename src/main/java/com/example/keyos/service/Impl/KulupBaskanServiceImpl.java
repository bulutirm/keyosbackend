package com.example.keyos.service.Impl;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.KulupBaskan;
import com.example.keyos.model.Talep;
import com.example.keyos.repository.KulupBaskanRepository;
import com.example.keyos.service.services.EtkinlikService;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.KulupBaskanService;
import com.example.keyos.service.services.TalepService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KulupBaskanServiceImpl implements KulupBaskanService {

    private final KulupBaskanRepository kulupBaskanRepository;
    private final EtkinlikTalepFormuService etkinlikTalepFormuService;
    private final EtkinlikService etkinlikService;
    private final TalepService talepService;

    public KulupBaskanServiceImpl(KulupBaskanRepository kulupBaskanRepository, EtkinlikTalepFormuService etkinlikTalepFormuService, EtkinlikService etkinlikService, TalepService talepService) {
        this.kulupBaskanRepository = kulupBaskanRepository;
        this.etkinlikTalepFormuService = etkinlikTalepFormuService;
        this.etkinlikService = etkinlikService;
        this.talepService = talepService;
    }

    @Override
    public List<KulupBaskan> getAll() {
        List<KulupBaskan> kulupBaskanList = kulupBaskanRepository.findAll();
        return kulupBaskanList;
    }

    @Override
    public KulupBaskan getById(Long id) {
        return kulupBaskanRepository.getById(id);
    }

    @Override
    public void save(KulupBaskan kulupBaskan) {
        kulupBaskanRepository.save(kulupBaskan);
    }

    @Override
    public void createEtkinlikTalepFormu(KulupBaskan kulupBaskan, Etkinlik etkinlik, Talep talep) {

        Etkinlik newEtkinlik = new Etkinlik();
        newEtkinlik.setKulup(kulupBaskan.getKulup());
        newEtkinlik.setEtkinlikAdi(etkinlik.getEtkinlikAdi());
        newEtkinlik.setKulupBaskan(kulupBaskan);
        newEtkinlik.setOlusturmaTarihi(LocalDateTime.now());
        newEtkinlik.setEtkinlikTarihi(etkinlik.getEtkinlikTarihi());
        newEtkinlik.setEtkinlikBaslamaSaati(etkinlik.getEtkinlikBaslamaSaati());
        newEtkinlik.setEtkinlikBitisSaati(etkinlik.getEtkinlikBitisSaati());
        newEtkinlik.setEtkinlikYeri(etkinlik.getEtkinlikYeri());
        newEtkinlik.setEtkinlikTipi(etkinlik.getEtkinlikTipi());
        newEtkinlik.setOnayDurumu(etkinlik.getOnayDurumu());
        newEtkinlik.setEtkinlikOnayDurumu(false);

        etkinlikService.save(etkinlik);

        Talep newTalep = new Talep();
        newTalep.setEtkinlik(etkinlik);
        newTalep.setKonukBilgisi(talep.getKonukBilgisi());
        newTalep.setSahneDuzeni(talep.getSahneDuzeni());
        newTalep.setMatbaaBaski(talep.getMatbaaBaski());

        talepService.save(newTalep);

        EtkinlikTalepFormu etkinlikTalepFormu = new EtkinlikTalepFormu();
        etkinlikTalepFormu.setEtkinlik(newEtkinlik);
        etkinlikTalepFormu.setTalep(newTalep);

        etkinlikTalepFormuService.save(etkinlikTalepFormu);
    }

    @Override
    public void changePassword(KulupBaskan kulupBaskan, String password) {
        kulupBaskan.setSifre(password);
        save(kulupBaskan);
    }
}
