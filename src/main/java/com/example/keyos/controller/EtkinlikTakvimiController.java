package com.example.keyos.controller;

import com.example.keyos.model.EtkinlikTakvimi;
import com.example.keyos.service.services.EtkinlikTakvimiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etkinliktakvimi")
public class EtkinlikTakvimiController {

    @Autowired
    private EtkinlikTakvimiService etkinlikTakvimiService;

    @GetMapping("/all")
    public List<EtkinlikTakvimi> getAllEtkinlikTakvimi() {
        return etkinlikTakvimiService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEtkinlikTakvimi(@RequestBody EtkinlikTakvimi etkinlikTakvimi) {
        etkinlikTakvimiService.save(etkinlikTakvimi);
        return ResponseEntity.ok("Etkinlik takvimi kaydedildi.");
    }
}
