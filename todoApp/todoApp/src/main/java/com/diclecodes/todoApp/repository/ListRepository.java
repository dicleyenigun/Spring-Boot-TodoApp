package com.diclecodes.todoApp.repository;

import com.diclecodes.todoApp.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ListRepository  extends JpaRepository<TodoList,Integer> {
}
