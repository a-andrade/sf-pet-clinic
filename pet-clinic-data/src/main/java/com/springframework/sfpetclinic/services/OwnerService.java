package com.springframework.sfpetclinic.services;

import com.springframework.sfpetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
