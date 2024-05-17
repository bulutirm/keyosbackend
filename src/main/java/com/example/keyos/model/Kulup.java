package com.example.keyos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="kulup")
@RequiredArgsConstructor
@ToString
public class Kulup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kulupAdi")
    private String kulupAdi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kulupBaskan")
    private KulupBaskan kulupBaskan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "danismanAkademisyenId")
    private DanismanAkademisyen danismanAkademisyen;

    @Column(name = "kurulusTarihi")
    private LocalDateTime kurulusTarihi;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "etkinlikId")
    private Etkinlik etkinlik;
}
