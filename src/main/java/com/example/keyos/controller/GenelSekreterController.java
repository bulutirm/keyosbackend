package com.example.keyos.controller;

import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.GenelSekreter;
import com.example.keyos.service.services.GenelSekreterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genelsekreter")
public class GenelSekreterController {

    @Autowired
    private GenelSekreterService genelSekreterService;

    @GetMapping("/all")
    public List<GenelSekreter> getAllGenelSekreter() {
        return genelSekreterService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveGenelSekreter(@RequestBody GenelSekreter genelSekreter) {
        genelSekreterService.save(genelSekreter);
        return ResponseEntity.ok("Genel sekreter kaydedildi.");
    }

    @PutMapping("/{id}/onay")
    public ResponseEntity<String> setOnay(@PathVariable Long id, @RequestBody EtkinlikTalepFormu etkinlikTalepFormu, @RequestParam Boolean onay) {
        GenelSekreter genelSekreter = genelSekreterService.getById(id);
        genelSekreterService.setOnay(genelSekreter, etkinlikTalepFormu, onay);
        return ResponseEntity.ok("Onay durumu güncellendi.");
    }

    @PutMapping("/{id}/changepassword")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestParam String password) {
        GenelSekreter genelSekreter = genelSekreterService.getById(id);
        genelSekreterService.changePassword(genelSekreter, password);
        return ResponseEntity.ok("Şifre güncellendi.");
    }
}

