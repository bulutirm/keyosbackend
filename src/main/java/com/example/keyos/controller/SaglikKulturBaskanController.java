package com.example.keyos.controller;

import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.SaglikKulturBaskani;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.SaglikKulturBaskanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saglikkulturbaskani")
public class SaglikKulturBaskanController {

    @Autowired
    private SaglikKulturBaskanService saglikKulturBaskanService;

    @Autowired
    private EtkinlikTalepFormuService etkinlikTalepFormuService;

    @GetMapping("/all")
    public List<SaglikKulturBaskani> getAllSaglikKulturBaskani() {
        return saglikKulturBaskanService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveSaglikKulturBaskani(@RequestBody SaglikKulturBaskani saglikKulturBaskani) {
        saglikKulturBaskanService.save(saglikKulturBaskani);
        return ResponseEntity.ok("Sağlık Kültür Başkanı kaydedildi.");
    }

    @PutMapping("/{id}/setonay")
    public ResponseEntity<String> setOnay(@PathVariable Long id, @RequestBody EtkinlikTalepFormu etkinlikTalepFormu, @RequestParam Boolean onay) {
        SaglikKulturBaskani saglikKulturBaskani = saglikKulturBaskanService.getById(id);
        saglikKulturBaskanService.setOnay(saglikKulturBaskani, etkinlikTalepFormu, onay);
        return ResponseEntity.ok("Onay durumu güncellendi.");
    }

    @PutMapping("/{id}/changepassword")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestParam String password) {
        SaglikKulturBaskani saglikKulturBaskani = saglikKulturBaskanService.getById(id);
        saglikKulturBaskanService.changePassword(saglikKulturBaskani, password);
        return ResponseEntity.ok("Şifre güncellendi.");
    }
}
