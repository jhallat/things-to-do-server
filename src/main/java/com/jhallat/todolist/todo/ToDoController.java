package com.jhallat.todolist.todo;

import com.jhallat.todolist.backlog.Backlog;
import com.jhallat.todolist.backlog.BacklogKey;
import com.jhallat.todolist.timestamp.TimestampGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ToDoController {

    //TODO Replace with user id from client
    private static final String DEFAULT_USER_ID = "jhallat";
    private final ToDoRepository todoRepository;
    private final TimestampGenerator timestampGenerator;

    @GetMapping("/todos")
    public List<ToDo> getTodos() {
        return todoRepository.findAllByUserId(DEFAULT_USER_ID);
    }


    @PostMapping("/todo")
    public ToDo addToDo(@RequestBody ToDo todo) {
        if (StringUtils.isEmpty(todo.getUserId())) {
            todo.setUserId(DEFAULT_USER_ID);
        }
        if (StringUtils.isEmpty(todo.getCreatedTimestamp())) {
            todo.setCreatedTimestamp(timestampGenerator.generateFromNow());
        }
        return todoRepository.save(todo);
    }

    @DeleteMapping("/todo/{userId}/{createdTimestamp}")
    public void deleteToDo(@PathVariable String userId, @PathVariable String createdTimestamp) {
        ToDoKey key = new ToDoKey();
        key.setUserId(userId);
        key.setCreatedTimestamp(createdTimestamp);
        todoRepository.deleteById(key);
    }
}
