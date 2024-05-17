package com.example.keyos.controller;

import com.example.keyos.model.Etkinlik;
import com.example.keyos.model.KulupBaskan;
import com.example.keyos.model.Talep;
import com.example.keyos.service.services.EtkinlikTalepFormuService;
import com.example.keyos.service.services.KulupBaskanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kulupbaskan")
public class KulupBaskanController {

    @Autowired
    private KulupBaskanService kulupBaskanService;

    @Autowired
    private EtkinlikTalepFormuService etkinlikTalepFormuService;

    @GetMapping("/all")
    public List<KulupBaskan> getAllKulupBaskan() {
        return kulupBaskanService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveKulupBaskan(@RequestBody KulupBaskan kulupBaskan) {
        kulupBaskanService.save(kulupBaskan);
        return ResponseEntity.ok("Kulup baskani kaydedildi.");
    }

    @PostMapping("/{id}/createetkinliktalepformu")
    public ResponseEntity<String> createEtkinlikTalepFormu(@PathVariable Long id, @RequestBody Etkinlik etkinlik, @RequestBody Talep talep) {
        KulupBaskan kulupBaskan = kulupBaskanService.getById(id);
        kulupBaskanService.createEtkinlikTalepFormu(kulupBaskan, etkinlik, talep);
        return ResponseEntity.ok("Etkinlik talep formu olusturuldu.");
    }

    @PutMapping("/{id}/changepassword")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestParam String password) {
        KulupBaskan kulupBaskan = kulupBaskanService.getById(id);
        kulupBaskanService.changePassword(kulupBaskan, password);
        return ResponseEntity.ok("Sifre degistirildi.");
    }
}
