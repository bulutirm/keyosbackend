package com.example.keyos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="danismanAkademisyen")
@RequiredArgsConstructor
@ToString
public class DanismanAkademisyen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "soyad")
    private String soyad;

    @Column(name = "email")
    private String email;

    @Column(name = "sifre")
    private String sifre;

    @Column(name = "unvan")
    private String unvan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kulupId")
    private Kulup kulup;



}
