package animalhealthcenterapplicationupdated.services;

import animalhealthcenterapplicationupdated.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
