package com.example.keyos.controller;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.Kulup;
import com.example.keyos.model.OnayDurumu;
import com.example.keyos.service.services.EtkinlikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etkinlik")
public class EtkinlikController {

    @Autowired
    private EtkinlikService etkinlikService;

    @GetMapping("/all")
    public List<Etkinlik> getAllEtkinlik() {
        return etkinlikService.getAll();
    }

    @GetMapping("/{id}")
    public Etkinlik getEtkinlikById(@PathVariable Long id) {
        return etkinlikService.getById(id);
    }

    @GetMapping("/bykulup")
    public List<Etkinlik> getEtkinlikByKulup(@RequestParam Long kulupId) {
        Kulup kulup = new Kulup();
        kulup.setId(kulupId);
        return etkinlikService.getEtkinlikByKulup(kulup);
    }

    @GetMapping("/onaydurumu")
    public OnayDurumu getOnayDurumuByEtkinlikId(@RequestParam Long etkinlikId) {
        return etkinlikService.getOnayDurumuByEtkinlikId(etkinlikId);
    }
}
