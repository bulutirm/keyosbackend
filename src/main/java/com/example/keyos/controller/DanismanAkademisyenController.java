package com.example.keyos.controller;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Etkinlik;
import com.example.keyos.service.services.DanismanAkedemisyenService;
import com.example.keyos.service.services.EtkinlikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/danismanakademisyen")
public class DanismanAkademisyenController {

    @Autowired
    private DanismanAkedemisyenService danismanAkedemisyenService;
    @Autowired
    private EtkinlikService etkinlikService;

    @GetMapping("/all")
    public List<DanismanAkademisyen> getAllDanismanAkademisyen(){
        return danismanAkedemisyenService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDanismanAkademisyen(@RequestBody DanismanAkademisyen danismanAkademisyen){
        danismanAkedemisyenService.save(danismanAkademisyen);
        return ResponseEntity.ok("Danışman akademisyen başarıyla kaydedildi");
    }

    @PutMapping("/{id}/onay")
    public ResponseEntity<String> setOnay(@PathVariable Long id, @RequestBody Boolean onay, @RequestParam Long etkinlikId){
        DanismanAkademisyen danismanAkademisyen = danismanAkedemisyenService.getById(id);
        Etkinlik etkinlik = etkinlikService.getById(id);
        danismanAkedemisyenService.setOnay(danismanAkademisyen, etkinlik, onay);
        return ResponseEntity.ok("Onay durumu güncellendi.");
    }

    public ResponseEntity<String> setPassword(@PathVariable Long id, @RequestParam String password){
        DanismanAkademisyen danismanAkademisyen = danismanAkedemisyenService.getById(id);
        danismanAkedemisyenService.setPassword(danismanAkademisyen, password);
        return ResponseEntity.ok("Şifre güncellendi.");
    }

}
