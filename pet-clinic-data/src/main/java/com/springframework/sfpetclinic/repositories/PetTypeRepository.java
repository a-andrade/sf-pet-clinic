package com.springframework.sfpetclinic.repositories;

import com.springframework.sfpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {



}
