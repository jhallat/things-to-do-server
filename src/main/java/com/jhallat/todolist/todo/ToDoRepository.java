package com.jhallat.todolist.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo, ToDoKey> {
    List<ToDo> findAllByUserId(String userId);
}
