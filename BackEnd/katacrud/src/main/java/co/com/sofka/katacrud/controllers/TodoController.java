package co.com.sofka.katacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofka.katacrud.models.Todo;
import co.com.sofka.katacrud.services.TodoService;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoServ;

    @GetMapping("api/todos")
    public Iterable<Todo> list(){
        return todoServ.list();
    }

    @PostMapping("api/todo/save")
    public Todo save(@RequestBody Todo newTodo){
        return todoServ.save(newTodo);
    }
    /*
    Este Request actualiza siempre y cuando en el JSON, envés de escribir "isCompleted": valor_boolean,
    así como se llama el atributo en su entidad, hay que usar "completed": valor_boolean.
    Tanto para la petición Post, como para la petición Put, se puede usar "completed": valor_boolean.
    */
    @PutMapping("api/todo/update")
    public Todo update(@RequestBody Todo newTodo){
        if(newTodo.getId() != null){
            return todoServ.save(newTodo);
        } else{
            throw new RuntimeException("No existe el TODO con el id " + newTodo.getId());
        }
    }

    @DeleteMapping("api/todo/delete/{id}")
    public void delete(@PathVariable("id") Long idTodo){
        todoServ.delete(idTodo);
    }

    @GetMapping("api/todo/{id}")
    public Todo get(@PathVariable("id") Long idTodo){
        return todoServ.get(idTodo);
    }
    
}
