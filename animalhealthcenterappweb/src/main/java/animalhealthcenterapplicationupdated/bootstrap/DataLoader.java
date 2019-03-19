package animalhealthcenterapplicationupdated.bootstrap;

import animalhealthcenterapplicationupdated.model.*;
import animalhealthcenterapplicationupdated.services.AnimalTypeService;
import animalhealthcenterapplicationupdated.services.OwnerService;
import animalhealthcenterapplicationupdated.services.SpecialityService;
import animalhealthcenterapplicationupdated.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final AnimalTypeService animalTypeService;
    private final VetService vetService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, AnimalTypeService animalTypeService, VetService vetService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.animalTypeService = animalTypeService;
        this.vetService = vetService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = animalTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }
    private void loadData(){
        AnimalType dog = new AnimalType();
        dog.setName("Dog");
        AnimalType saveDogAnimalType=  animalTypeService.save(dog);

        AnimalType cat = new AnimalType();
        dog.setName("Cat");
        AnimalType saveCatAnimalType=  animalTypeService.save(cat);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);

        Speciality dentistry= new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Maimi");
        owner1.setTelephone("23468746778");

        Animal mikeAnimal = new Animal();
        mikeAnimal.setAnimalType(saveDogAnimalType);
        mikeAnimal.setOwner(owner1);
        mikeAnimal.setBirthDate(LocalDate.now());
        mikeAnimal.setName("Rosco");
        owner1.getAnimals().add(mikeAnimal);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanance");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Maimi");
        owner2.setTelephone("23468746778");

        Animal fionaCat = new Animal();
        fionaCat.setName("Just Cat");
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setAnimalType(saveCatAnimalType);
        owner2.getAnimals().add(fionaCat);
        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Joshua");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");


    }
}
