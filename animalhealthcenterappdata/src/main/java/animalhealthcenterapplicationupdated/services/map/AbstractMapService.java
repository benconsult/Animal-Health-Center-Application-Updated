package animalhealthcenterapplicationupdated.services.map;

import animalhealthcenterapplicationupdated.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>{
    //define the hashmap
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    //since we dont know the type of object returned, we use id and obj
    T save(T object) {
        if (object != null) {//obj not empty
            if (object.getId() == null) {//has no id
                object.setId(getNextId());//set id

            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        // becomes obsolete map.put(id, object);
        return object;
    }

    void deleteBYId(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    //impement ID to use Hashmap, auto generate ID e.g obj 3,4,5,6...
    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;//if not initialize , it wont increment
        }
        return nextId;//increments by 1

    }

    }
