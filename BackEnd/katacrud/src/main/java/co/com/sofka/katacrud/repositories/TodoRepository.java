package co.com.sofka.katacrud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sofka.katacrud.models.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{
    
}
