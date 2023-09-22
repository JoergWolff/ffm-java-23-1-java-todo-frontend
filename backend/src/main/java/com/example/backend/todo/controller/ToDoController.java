package com.example.backend.todo.controller;

import com.example.backend.todo.model.NewToDo;
import com.example.backend.todo.model.ToDo;
import com.example.backend.todo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;
    @GetMapping("/todo")
    public List<ToDo> getToDos(){
        return toDoService.findAllTodos();
    }
    @GetMapping("/todo/{id}")
    public ToDo getToDoById(@PathVariable String id){
        return toDoService.findToDoById(id);
    }
    @PostMapping("/todo")
    public ToDo addToDo(@RequestBody NewToDo newToDo){
        return toDoService.saveToDo(newToDo);
    }

    @PutMapping("/todo/{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDo toDo){
        System.out.println(toDo);
        toDoService.updateTodo(id, toDo);
        return toDo;
    }

    @DeleteMapping("/todo/{id}")
    public ToDo  deleteToDo(@PathVariable String id){
        ToDo returnTodo = toDoService.findToDoById(id);
        toDoService.deleteToDo(id);
        return returnTodo;
    }
}
