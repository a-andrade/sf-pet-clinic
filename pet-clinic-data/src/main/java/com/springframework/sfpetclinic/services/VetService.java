package com.springframework.sfpetclinic.services;

import com.springframework.sfpetclinic.models.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
