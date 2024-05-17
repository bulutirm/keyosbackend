package com.example.keyos.service.Impl;

import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.SaglikKulturBaskani;
import com.example.keyos.repository.SaglikKulturBaskaniRepository;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.SaglikKulturBaskanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaglikKulturBaskanServiceImpl implements SaglikKulturBaskanService {

    private final SaglikKulturBaskaniRepository saglikKulturBaskaniRepository;
    private final EtkinlikTalepFormuService etkinlikTalepFormuService;

    public SaglikKulturBaskanServiceImpl(SaglikKulturBaskaniRepository saglikKulturBaskaniRepository, EtkinlikTalepFormuService etkinlikTalepFormuService) {
        this.saglikKulturBaskaniRepository = saglikKulturBaskaniRepository;
        this.etkinlikTalepFormuService = etkinlikTalepFormuService;
    }

    @Override
    public List<SaglikKulturBaskani> getAll() {
        List<SaglikKulturBaskani> saglikKulturBaskaniList = saglikKulturBaskaniRepository.findAll();
        return saglikKulturBaskaniList;
    }

    @Override
    public SaglikKulturBaskani getById(Long id) {
        return saglikKulturBaskaniRepository.getById(id);
    }

    @Override
    public void save(SaglikKulturBaskani saglikKulturBaskani) {
        saglikKulturBaskaniRepository.save(saglikKulturBaskani);
    }

    @Override
    public void setOnay(SaglikKulturBaskani saglikKulturBaskani, EtkinlikTalepFormu etkinlikTalepFormu, Boolean onay) {
        List<EtkinlikTalepFormu> etkinlikTalepFormuList = etkinlikTalepFormuService.getEtkinlikTalepFormu();
        for(EtkinlikTalepFormu etkinlikTalepFormu1 : etkinlikTalepFormuList){
            if(etkinlikTalepFormu1.equals(etkinlikTalepFormu)){
                if(onay.equals(true)){
                    etkinlikTalepFormu1.getEtkinlik().getOnayDurumu().setOnaySKDBaskani(true);
                }else if(onay.equals(false)){
                    etkinlikTalepFormu1.getEtkinlik().getOnayDurumu().setOnaySKDBaskani(false);
                }
            }
        }
    }

    @Override
    public void changePassword(SaglikKulturBaskani saglikKulturBaskani, String password) {
        saglikKulturBaskani.setSifre(password);
        save(saglikKulturBaskani);
    }
}
