package com.springframework.sfpetclinic.repositories;

import com.springframework.sfpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {



}
