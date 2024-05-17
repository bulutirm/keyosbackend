package com.example.keyos.controller;

import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etkinliktalepformu")
public class EtkinlikTalepFormuController {

    @Autowired
    private EtkinlikTalepFormuService etkinlikTalepFormuService;

    @GetMapping("/all")
    public List<EtkinlikTalepFormu> getAllEtkinlikTalepFormu() {
        return etkinlikTalepFormuService.getEtkinlikTalepFormu();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEtkinlikTalepFormu(@RequestBody EtkinlikTalepFormu etkinlikTalepFormu) {
        etkinlikTalepFormuService.save(etkinlikTalepFormu);
        return ResponseEntity.ok("Etkinlik talep formu kaydedildi.");
    }
}
