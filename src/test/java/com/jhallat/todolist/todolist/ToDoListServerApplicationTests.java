package com.jhallat.todolist.todolist;

import com.jhallat.todolist.backlog.BacklogController;
import com.jhallat.todolist.idea.IdeaController;
import com.jhallat.todolist.todo.ToDoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ToDoListServerApplicationTests {

    @Autowired
    private BacklogController backlogController;

    @Autowired
    private IdeaController ideaController;

    @Autowired
    private ToDoController toDoController;

    @Test
    void contextLoads() {
        assertNotNull(backlogController);
        assertNotNull(ideaController);
        assertNotNull(toDoController);
    }

}
