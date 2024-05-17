package com.example.keyos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="onayDurumu")
@RequiredArgsConstructor
@ToString
public class OnayDurumu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "onayKulupBaskan")
    private Boolean onayKulupBaskan = false;

    @Column(name = "onayDanismanAkademisyen")
    private Boolean onayDanismanAkademisyen = false;

    @Column(name = "onayEtkinlikOfisPersonel")
    private Boolean onayEtkinlikOfisPersonel = false;

    @Column(name = "onayGenelSekreter")
    private Boolean onayGenelSekreter = false;

    @Column(name = "onaySKDBaskani")
    private Boolean onaySKDBaskani = false;
}
