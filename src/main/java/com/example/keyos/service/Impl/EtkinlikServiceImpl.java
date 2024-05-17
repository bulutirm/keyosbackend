package com.example.keyos.service.Impl;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.EtkinlikTakvimi;
import com.example.keyos.model.Kulup;
import com.example.keyos.model.OnayDurumu;
import com.example.keyos.repository.EtkinlikRepository;
import com.example.keyos.service.services.EtkinlikService;
import com.example.keyos.service.services.EtkinlikTakvimiService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtkinlikServiceImpl implements EtkinlikService {

    private final EtkinlikRepository etkinlikRepository;
    private final EtkinlikTakvimiService etkinlikTakvimiService;

    public EtkinlikServiceImpl(EtkinlikRepository etkinlikRepository, EtkinlikTakvimiService etkinlikTakvimiService) {
        this.etkinlikRepository = etkinlikRepository;
        this.etkinlikTakvimiService = etkinlikTakvimiService;
    }

    @Override
    public List<Etkinlik> getAll() {
        List<Etkinlik> etkinlikList = etkinlikRepository.findAll();
        return etkinlikList;
    }

    @Override
    public Etkinlik getById(Long id) {
        return etkinlikRepository.getById(id);
    }

    @Override
    public void save(Etkinlik etkinlik) {
        etkinlikRepository.save(etkinlik);
    }

    @Override
    public List<Etkinlik> getEtkinlikByKulup(Kulup kulup) {
        List<Etkinlik> etkinlikList = etkinlikRepository.findEtkinlikByKulup(kulup);
        return etkinlikList;
    }

    @Override
    public OnayDurumu getOnayDurumuByEtkinlikId(Long etkinlikId) {
        return etkinlikRepository.findOnayDurumuByEtkinlikId(etkinlikId);
    }

    @Override
    @Scheduled(cron = "0 * * * * *")
    public void controlEtkinlikOnayDurum() {
        List<Etkinlik> etkinlikList = getAll();
        for(Etkinlik etkinlik : etkinlikList){
            if(!etkinlik.isEtkinlikOnayDurumu()){
                boolean onay = checkOnayDurumu(etkinlik);
                if(onay){
                    etkinlik.setEtkinlikOnayDurumu(true);
                    EtkinlikTakvimi etkinlikTakvimi = new EtkinlikTakvimi();
                    etkinlikTakvimi.setEtkinlik(etkinlik);
                    etkinlikTakvimiService.save(etkinlikTakvimi);
                }
            }
        }
    }

    private Boolean checkOnayDurumu(Etkinlik etkinlik) {
        boolean onayDanismanAkademisyen = etkinlik.getOnayDurumu().getOnayDanismanAkademisyen();
        boolean onayGenelSekreter = etkinlik.getOnayDurumu().getOnayGenelSekreter();
        boolean onaySKDBaskan = etkinlik.getOnayDurumu().getOnaySKDBaskani();
        boolean onayEtkinlikOfisPersonel = etkinlik.getOnayDurumu().getOnayEtkinlikOfisPersonel();

        if(onayDanismanAkademisyen && onayGenelSekreter && onaySKDBaskan && onayEtkinlikOfisPersonel){
            return true;
        }
        return false;
    }


}
