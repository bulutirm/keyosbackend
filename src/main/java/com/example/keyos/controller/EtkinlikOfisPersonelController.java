package com.example.keyos.controller;

import com.example.keyos.model.EtkinlikOfisPersonel;
import com.example.keyos.model.EtkinlikTalepFormu;
import com.example.keyos.model.Kulup;
import com.example.keyos.model.KulupBaskan;
import com.example.keyos.service.services.EtkinlikOfisPersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etkinlikofispersonel")
public class EtkinlikOfisPersonelController {

    @Autowired
    private EtkinlikOfisPersonelService etkinlikOfisPersonelService;

    @GetMapping("/all")
    public List<EtkinlikOfisPersonel> getAllEtkinlikOfisPersonel(){
        return etkinlikOfisPersonelService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEtkinlikOfisPersonel(@RequestBody EtkinlikOfisPersonel etkinlikOfisPersonel){
        etkinlikOfisPersonelService.save(etkinlikOfisPersonel);
        return ResponseEntity.ok("Etkinlik ofis personeli kaydedildi");
    }

    @PutMapping("/{id}/onay")
    public ResponseEntity<String> setOnay(@PathVariable Long id, @RequestBody EtkinlikTalepFormu etkinlikTalepFormu, @RequestParam Boolean onay){
        EtkinlikOfisPersonel etkinlikOfisPersonel = etkinlikOfisPersonelService.getById(id);
        etkinlikOfisPersonelService.setOnay(etkinlikOfisPersonel, etkinlikTalepFormu, onay);
        return ResponseEntity.ok("Onay durumu güncellendi.");
    }

    @PostMapping("/addkulupandkulupbaskan")
    public ResponseEntity<String> addKulupAndKulupBaskan(@RequestBody Kulup kulup, @RequestBody KulupBaskan kulupBaskan) {
        etkinlikOfisPersonelService.addKulupAndKulupBaskan(kulup, kulupBaskan);
        return ResponseEntity.ok("Kulup ve KulupBaskan eklendi.");
    }

    @PutMapping("/{id}/changepassword")
    public ResponseEntity<String> changePassword(@PathVariable Long id, @RequestParam String password) {
        EtkinlikOfisPersonel etkinlikOfisPersonel = etkinlikOfisPersonelService.getById(id);
        etkinlikOfisPersonelService.changePassword(etkinlikOfisPersonel, password);
        return ResponseEntity.ok("Şifre güncellendi.");
    }
}
