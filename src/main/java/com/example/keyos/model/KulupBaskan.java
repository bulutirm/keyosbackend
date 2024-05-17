package com.example.keyos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="kulupBaskan")
@RequiredArgsConstructor
@ToString
public class KulupBaskan {

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
    private String sifre = "12345";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kulupId")
    private Kulup kulup;
}
