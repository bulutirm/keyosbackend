package com.example.keyos.service.Impl;

import com.example.keyos.model.*;
import com.example.keyos.repository.EtkinlikOfisPersonelRepository;
import com.example.keyos.service.services.EtkinlikOfisPersonelService;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.KulupBaskanService;
import com.example.keyos.service.services.KulupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtkinlikOfisPersonelServiceImpl implements EtkinlikOfisPersonelService {

    private final EtkinlikOfisPersonelRepository etkinlikOfisPersonelRepository;
    private final EtkinlikTalepFormuService etkinlikTalepFormuService;
    private final KulupService kulupService;
    private final KulupBaskanService kulupBaskanService;

    public EtkinlikOfisPersonelServiceImpl(EtkinlikOfisPersonelRepository etkinlikOfisPersonelRepository, EtkinlikTalepFormuService etkinlikTalepFormuService, KulupService kulupService, KulupBaskanService kulupBaskanService) {
        this.etkinlikOfisPersonelRepository = etkinlikOfisPersonelRepository;
        this.etkinlikTalepFormuService = etkinlikTalepFormuService;
        this.kulupService = kulupService;
        this.kulupBaskanService = kulupBaskanService;
    }

    @Override
    public List<EtkinlikOfisPersonel> getAll() {
        List<EtkinlikOfisPersonel> etkinlikOfisPersonelList = etkinlikOfisPersonelRepository.findAll();
        return etkinlikOfisPersonelList;
    }

    @Override
    public EtkinlikOfisPersonel getById(Long id) {
        return etkinlikOfisPersonelRepository.getById(id);
    }


    @Override
    public void save(EtkinlikOfisPersonel etkinlikOfisPersonel) {
        etkinlikOfisPersonelRepository.save(etkinlikOfisPersonel);
    }

    @Override
    public void setOnay(EtkinlikOfisPersonel etkinlikOfisPersonel, EtkinlikTalepFormu etkinlikTalepFormu, Boolean onay) {
        List<EtkinlikTalepFormu> etkinlikTalepFormuList = etkinlikTalepFormuService.getEtkinlikTalepFormu();
        for(EtkinlikTalepFormu etkinlikTalepFormu1 : etkinlikTalepFormuList){
            if(etkinlikTalepFormu1.equals(etkinlikTalepFormu)){
                if(onay.equals(true)){
                    etkinlikTalepFormu1.getEtkinlik().getOnayDurumu().setOnayEtkinlikOfisPersonel(true);
                }else if(onay.equals(false)){
                    etkinlikTalepFormu1.getEtkinlik().getOnayDurumu().setOnayEtkinlikOfisPersonel(false);
                }
            }
        }
    }

    @Override
    public void addKulupAndKulupBaskan(Kulup kulup, KulupBaskan kulupBaskan) {
        Kulup newKulup = new Kulup();
        newKulup.setKulupAdi(kulup.getKulupAdi());
        newKulup.setKulupBaskan(kulupBaskan);
        newKulup.setDanismanAkademisyen(kulup.getDanismanAkademisyen());
        newKulup.setKurulusTarihi(kulup.getKurulusTarihi());

        kulupService.save(newKulup);

        KulupBaskan newKulupBaskan = new KulupBaskan();
        newKulupBaskan.setAd(kulupBaskan.getAd());
        newKulupBaskan.setSoyad(kulupBaskan.getSoyad());
        newKulupBaskan.setEmail(kulupBaskan.getEmail());
        newKulupBaskan.setKulup(kulup);

        kulupBaskanService.save(newKulupBaskan);
    }

    @Override
    public void changePassword(EtkinlikOfisPersonel etkinlikOfisPersonel, String password) {
        etkinlikOfisPersonel.setSifre(password);
        save(etkinlikOfisPersonel);
    }
}
