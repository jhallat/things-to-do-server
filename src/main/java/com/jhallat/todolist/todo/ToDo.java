package com.jhallat.todolist.todo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "to-do-list.todos")
public class ToDo {

    @Id
    private ToDoKey todoKey;
    private String description;
    private boolean completed;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return todoKey != null ? todoKey.getUserId() : null;
    }

    public void setUserId(String userId) {
        if (todoKey == null) {
            todoKey = new ToDoKey();
        }
        todoKey.setUserId(userId);
    }

    @DynamoDBRangeKey(attributeName = "createdTimestamp")
    public String getCreatedTimestamp() {
        return todoKey != null ? todoKey.getCreatedTimestamp() : null;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        if (todoKey == null) {
            todoKey = new ToDoKey();
        }
        todoKey.setCreatedTimestamp(createdTimestamp);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
