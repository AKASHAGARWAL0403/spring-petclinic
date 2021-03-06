package com.springframework.petclinic.Bootstrap;

import com.springframework.petclinic.Services.OwnerService;
import com.springframework.petclinic.Services.PetTypeService;
import com.springframework.petclinic.Services.SpecialityService;
import com.springframework.petclinic.Services.VetService;
import com.springframework.petclinic.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPet().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setDate(LocalDate.now());
        fionasCat.setType(savedCatType);
        owner2.getPet().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Owner Loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("aritra");
        vet1.setLastName("chustafi");
        vet1.getSpecialitySet().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("ashutosh");
        vet2.setLastName("sahu");
        vet2.getSpecialitySet().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Vet Loaded");
    }
}
