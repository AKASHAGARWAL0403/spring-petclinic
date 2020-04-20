package com.springframework.petclinic.Services.map;

import com.springframework.petclinic.Services.CrudService;
import com.springframework.petclinic.Services.OwnerService;
import com.springframework.petclinic.Services.PetService;
import com.springframework.petclinic.Services.PetTypeService;
import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Pet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Scope(value = "singleton")
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPet() != null){
                object.getPet().forEach(pet -> {
                    if(pet.getType() != null){
                        if(pet.getType().getId() == null){
                            pet.setType(petTypeService.save(pet.getType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is Required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else{
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
