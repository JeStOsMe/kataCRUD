package co.com.sofka.katacrud.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.sofka.katacrud.models.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{
    
}
