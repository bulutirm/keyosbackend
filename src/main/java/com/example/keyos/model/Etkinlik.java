package com.example.keyos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="etkinlik")
@RequiredArgsConstructor
@ToString
public class Etkinlik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kulupId")
    private Kulup kulup;

    @Column(name = "etkinlikAdi")
    private String etkinlikAdi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kulupBaskanId")
    private KulupBaskan kulupBaskan;

    @Column(name = "olusturmaTarihi")
    private LocalDateTime olusturmaTarihi = LocalDateTime.now();

    @Column(name = "degistirmeTarihi")
    private LocalDateTime degistirilmeTarihi = LocalDateTime.now();

    @Column(name = "etkinlikTarihi")
    private LocalDateTime etkinlikTarihi;

    @Column(name = "etkinlikBaslamaSaati")
    private LocalDateTime etkinlikBaslamaSaati;

    @Column(name = "etkinlikBitisSaati")
    private LocalDateTime etkinlikBitisSaati;

    @Column(name = "etkinlikYeri")
    private String etkinlikYeri;

    @Column(name = "etkinlikTipi")
    private String etkinlikTipi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "onayDurumuId")
    private OnayDurumu onayDurumu;

    @Column(name = "etkinlikOnayDurumu")
    private boolean etkinlikOnayDurumu = false;

}
