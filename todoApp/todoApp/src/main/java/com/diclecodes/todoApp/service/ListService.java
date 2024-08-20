package com.diclecodes.todoApp.service;

import com.diclecodes.todoApp.model.TodoList;

import java.util.List;

public interface ListService {

    public TodoList saveTodoList(TodoList todoList);
    public List<TodoList> getAllTodoLists();
}
