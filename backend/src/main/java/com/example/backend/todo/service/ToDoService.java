package com.example.backend.todo.service;

import com.example.backend.chatgpt.service.ChatGptApiService;
import com.example.backend.helper.IdService;
import com.example.backend.todo.ToDoRepository;
import com.example.backend.todo.model.NewToDo;
import com.example.backend.todo.model.ToDo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    private final ChatGptApiService chatGptService;


    public List<ToDo> findAllTodos() {
        return repository.findAll();
    }

    public ToDo findToDoById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public ToDo saveToDo(NewToDo newToDo) {
        String description = chatGptService.askChatGpt(newToDo.description());
        return repository.save(new ToDo(IdService.getId(), description, newToDo.status()));
    }

    public ToDo updateTodo(String id, ToDo toDo){
        ToDo toDoToUpdate = new ToDo(id, toDo.description(),toDo.status());
        return  repository.save(toDoToUpdate);
    }

    public void deleteToDo(String id) {
        repository.deleteById(id);
    }
}
