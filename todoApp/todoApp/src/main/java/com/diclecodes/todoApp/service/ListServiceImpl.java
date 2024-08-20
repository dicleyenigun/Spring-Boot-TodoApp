package com.diclecodes.todoApp.service;

import com.diclecodes.todoApp.model.TodoList;
import com.diclecodes.todoApp.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListRepository todoListRepository;

    @Override
    public TodoList saveTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public List<TodoList> getAllTodoLists(){
        return todoListRepository.findAll();
    }


}