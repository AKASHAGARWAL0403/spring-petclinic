package com.springframework.petclinic.Services.map;

import com.springframework.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long , T> map = new HashMap();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId() , object);
        }else{
            throw  new RuntimeException("Object should not be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    Long getNextId(){
        Long next_id = null;
        try{
            next_id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            next_id = 1L;
        }
        return next_id;
    }


}
