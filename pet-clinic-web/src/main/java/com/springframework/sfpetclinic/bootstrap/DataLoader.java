package com.springframework.sfpetclinic.bootstrap;

import com.springframework.sfpetclinic.models.*;
import com.springframework.sfpetclinic.services.OwnerService;
import com.springframework.sfpetclinic.services.PetTypeService;
import com.springframework.sfpetclinic.services.SpecialtyService;
import com.springframework.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        // adding owners to bootstrap

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        //ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenanne");

        //ownerService.save(owner2);

        System.out.println("Loaded owners...");

        // adding vets to bootstrap

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        //vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        //vetService.save(vet2);

        System.out.println("Loaded vets...");

        // adding petTypes to bootstrap

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded petTypes...");

        // adding owners contact info to bootstrap

        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123-123-1234");

        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123-123-1234");

        //ownerService.save(owner1);
        //ownerService.save(owner2);

        System.out.println("Loaded contact info...");

        // adding pet and petType to bootstrap

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Luna");
        owner2.getPets().add(fionasPet);

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded pets...");

        // adding specialties to vets

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);
        vet1.getSpecialties().add(savedRadiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);
        vet2.getSpecialties().add(savedSurgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded specialties...");
    }
}
