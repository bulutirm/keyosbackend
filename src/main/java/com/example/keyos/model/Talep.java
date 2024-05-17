package com.example.keyos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="talep")
@RequiredArgsConstructor
@ToString
public class Talep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "etkinlik")
    private Etkinlik etkinlik;

    @Column(name = "konukBilgisi")
    private String konukBilgisi;

    @Column(name = "sahneDuzeni")
    private String sahneDuzeni;

    @Column(name = "matbaaBaski")
    private String matbaaBaski;




}
