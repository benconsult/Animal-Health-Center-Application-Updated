package animalhealthcenterapplicationupdated.services.springdatajpa;

import animalhealthcenterapplicationupdated.model.Owner;
import animalhealthcenterapplicationupdated.repositories.AnimalRepository;
import animalhealthcenterapplicationupdated.repositories.AnimalTypeRepository;
import animalhealthcenterapplicationupdated.repositories.OwnerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Set;

import static org.junit.Assert.assertNotNull;
//@ExtendsWith(MockitoExtensions.class) not implemented
@RunWith(MockitoJUnitRunner.class)
public class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    AnimalRepository animalRepository;

    @Mock
    AnimalTypeRepository animalTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByLastName() {
        Owner smith = service.findByLastName("smith");
    }

    @Test
    public void findAll() {
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
        service.delete(returnOwner);

    }

    @Test
    public void deleteById() {
    }
}