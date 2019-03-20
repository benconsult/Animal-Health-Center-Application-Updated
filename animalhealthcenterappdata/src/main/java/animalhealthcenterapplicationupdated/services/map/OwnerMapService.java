package animalhealthcenterapplicationupdated.services.map;

import animalhealthcenterapplicationupdated.model.Animal;
import animalhealthcenterapplicationupdated.model.Owner;
import animalhealthcenterapplicationupdated.services.AnimalService;
import animalhealthcenterapplicationupdated.services.AnimalTypeService;
import animalhealthcenterapplicationupdated.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private AnimalService animalService;
    private AnimalTypeService animalTypeService;

    public OwnerMapService(AnimalService animalService, AnimalTypeService animalTypeService) {
        this.animalService = animalService;
        this.animalTypeService = animalTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteBYId(id);

    }

    @Override
    public Owner save(Owner object) {
        Owner savaOwner = null;
        if(object != null){
            if(object.getAnimals() != null){
                object.getAnimals().forEach(animal -> {
                    if(animal.getAnimalType() != null){
                        if(animal.getAnimalType().getId() == null){
                            animal.setAnimalType(animalTypeService.save(animal.getAnimalType()));
                        }
                    }else {throw new RuntimeException("Pet Type is required");
                    }
                    if(animal.getId() == null){
                        Animal saveAnimal = animalService.save(animal);
                        animal.setId(saveAnimal.getId());
                    }
                });
            }
            return super.save(object);
        }else{
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
