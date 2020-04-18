package com.springframework.petclinic.Services;

import com.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

}
