package com.example.backend.todo.controller;

import com.example.backend.todo.model.NewToDo;
import com.example.backend.todo.model.ToDo;
import com.example.backend.todo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@AllArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;
    @GetMapping
    public List<ToDo> getToDos(){
        return toDoService.findAllTodos();
    }
    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable String id){
        return toDoService.findToDoById(id);
    }
    @PostMapping
    public ToDo addToDo(@RequestBody NewToDo newToDo){
        return toDoService.saveToDo(newToDo);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDo toDo){
        System.out.println(toDo);
        toDoService.updateTodo(id, toDo);
        return toDo;
    }

    @DeleteMapping("/{id}")
    public ToDo  deleteToDo(@PathVariable String id){
        ToDo returnTodo = toDoService.findToDoById(id);
        toDoService.deleteToDo(id);
        return returnTodo;
    }
}
