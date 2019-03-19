package animalhealthcenterapplicationupdated.services.map;

import animalhealthcenterapplicationupdated.model.AnimalType;
import animalhealthcenterapplicationupdated.services.AnimalTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AnimalTypeMapService extends AbstractMapService<AnimalType, Long> implements AnimalTypeService {
    @Override
    public Set<AnimalType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
     super.deleteBYId(id);
    }

    @Override
    public AnimalType save(AnimalType object) {
        return super.save(object);
    }

    @Override
    public AnimalType findById(Long id) {
        return super.findById(id);
    }
}
