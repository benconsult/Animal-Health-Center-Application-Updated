package animalhealthcenterapplicationupdated.services.map;

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
    public void deleteById(Long id) {
        super.deleteBYId(id);

    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
