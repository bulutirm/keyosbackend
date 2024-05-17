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
@Table(name="etkinlikTalepFormu")
@RequiredArgsConstructor
@ToString
public class EtkinlikTalepFormu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "etkinlik")
    private Etkinlik etkinlik;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "talep")
    private Talep talep;
}
