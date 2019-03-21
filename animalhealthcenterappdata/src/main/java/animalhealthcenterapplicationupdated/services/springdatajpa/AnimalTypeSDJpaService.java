package animalhealthcenterapplicationupdated.services.springdatajpa;

import animalhealthcenterapplicationupdated.model.AnimalType;
import animalhealthcenterapplicationupdated.repositories.AnimalTypeRepository;
import animalhealthcenterapplicationupdated.services.AnimalTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AnimalTypeSDJpaService implements AnimalTypeService {
    private final AnimalTypeRepository animalTypeRepository;

    public AnimalTypeSDJpaService(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public Set<AnimalType> findAll() {
        Set<AnimalType> animalTypes = new HashSet<>();
        animalTypeRepository.findAll().forEach(animalTypes::add);
        return animalTypes;
    }

    @Override
    public AnimalType findById(Long aLong) {
        return animalTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public AnimalType save(AnimalType object) {
        return animalTypeRepository.save(object);
    }

    @Override
    public void delete(AnimalType object) {
    animalTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
    animalTypeRepository.deleteById(aLong);
    }
}
