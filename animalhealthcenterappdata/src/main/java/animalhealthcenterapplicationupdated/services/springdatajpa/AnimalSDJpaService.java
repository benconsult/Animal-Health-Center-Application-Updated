package animalhealthcenterapplicationupdated.services.springdatajpa;

import animalhealthcenterapplicationupdated.model.Animal;
import animalhealthcenterapplicationupdated.repositories.AnimalRepository;
import animalhealthcenterapplicationupdated.services.AnimalService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AnimalSDJpaService implements AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalSDJpaService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Set<Animal> findAll() {
        Set<Animal> animals = new HashSet<>();
        animalRepository.findAll().forEach(animals::add);
        return animals;
    }

    @Override
    public Animal findById(Long aLong) {
        return animalRepository.findById(aLong).orElse(null);
    }

    @Override
    public Animal save(Animal object) {
        return animalRepository.save(object);
    }

    @Override
    public void delete(Animal object) {
    animalRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
    animalRepository.deleteById(aLong);
    }
}
