package com.springframework.sfpetclinic.repositories;

import com.springframework.sfpetclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Vet, Long> {



}
