package com.springframework.petclinic.Bootstrap;

import com.springframework.petclinic.Services.OwnerService;
import com.springframework.petclinic.Services.PetTypeService;
import com.springframework.petclinic.Services.VetService;
import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.PetType;
import com.springframework.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("akash");
        owner1.setLastName("agarwal");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("radhika");
        owner2.setLastName("garg");

        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("aritra");
        vet1.setLastName("chustafi");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("ashutosh");
        vet2.setLastName("sahu");
        vetService.save(vet2);

        System.out.println("Vet Loaded");

    }
}
