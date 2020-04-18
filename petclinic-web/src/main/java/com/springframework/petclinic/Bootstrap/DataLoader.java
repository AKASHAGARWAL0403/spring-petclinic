package com.springframework.petclinic.Bootstrap;

import com.springframework.petclinic.Services.OwnerService;
import com.springframework.petclinic.Services.VetService;
import com.springframework.petclinic.model.Owner;
import com.springframework.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
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
