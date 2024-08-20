package com.diclecodes.todoApp.controller;

import com.diclecodes.todoApp.controller.ListController;
import com.diclecodes.todoApp.model.TodoList;
import com.diclecodes.todoApp.service.ListService;
import com.diclecodes.todoApp.service.ListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoList")
@CrossOrigin
public class ListController {
    @Autowired
    private ListService todoListService;

    @PostMapping("/add")
    public String add(@RequestBody TodoList todoList){
        todoListService.saveTodoList(todoList);
        return "New todoList is added";
    }

    @GetMapping("/getAll")
    public List<TodoList> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }
}
