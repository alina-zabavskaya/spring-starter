package com.dmved.spring.database.repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

public interface CrudRepository <K , E>{

    Optional<E> findById(K id);

    void delete(E entity);
}
