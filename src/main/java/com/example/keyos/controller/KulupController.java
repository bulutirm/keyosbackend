package com.example.keyos.controller;

import com.example.keyos.model.DanismanAkademisyen;
import com.example.keyos.model.Kulup;
import com.example.keyos.service.services.KulupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kulup")
public class KulupController {

    @Autowired
    private KulupService kulupService;

    @PostMapping("/save")
    public ResponseEntity<String> saveKulup(@RequestBody Kulup kulup) {
        kulupService.save(kulup);
        return ResponseEntity.ok("Kulup kaydedildi.");
    }

    @GetMapping("/bydanisman")
    public List<Kulup> getKulupByDanisman(@RequestParam Long danismanId) {
        DanismanAkademisyen danismanAkademisyen = new DanismanAkademisyen();
        danismanAkademisyen.setId(danismanId);
        return kulupService.getKulupByDanisman(danismanAkademisyen);
    }
}
