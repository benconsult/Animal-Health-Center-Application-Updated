package animalhealthcenterapplicationupdated.services.springdatajpa;

import animalhealthcenterapplicationupdated.model.Owner;
import animalhealthcenterapplicationupdated.repositories.AnimalRepository;
import animalhealthcenterapplicationupdated.repositories.AnimalTypeRepository;
import animalhealthcenterapplicationupdated.repositories.OwnerRepository;
import animalhealthcenterapplicationupdated.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final AnimalRepository animalRepository;
    private final AnimalTypeRepository animalTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, AnimalRepository animalRepository, AnimalTypeRepository animalTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.animalRepository = animalRepository;
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {

        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
       ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
   ownerRepository.deleteById(aLong);
    }
}
