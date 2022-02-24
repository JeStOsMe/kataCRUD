package co.com.sofka.katacrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofka.katacrud.models.Todo;
import co.com.sofka.katacrud.repositories.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepo;

    private Iterable<Todo> list(){
        return todoRepo.findAll();
    }

    private Todo save(Todo newTodo){
        return todoRepo.save(newTodo);
    }

    public void delete(Long idTodo){
        todoRepo.delete(get(idTodo));
    }

    public Todo get(Long idTodo){
        return todoRepo.findById(idTodo).orElseThrow();
    }
    
}
