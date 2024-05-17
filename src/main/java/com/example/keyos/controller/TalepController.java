package com.example.keyos.controller;

import com.example.keyos.model.Talep;
import com.example.keyos.service.services.TalepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/talep")
public class TalepController {

    @Autowired
    private TalepService talepService;

    @GetMapping("/all")
    public List<Talep> getAllTalep() {
        return talepService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTalep(@RequestBody Talep talep) {
        talepService.save(talep);
        return ResponseEntity.ok("Talep kaydedildi.");
    }
}

