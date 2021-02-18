package com.jhallat.todolist.todo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Data;

import java.io.Serializable;

@Data
public class ToDoKey implements Serializable {

    @DynamoDBHashKey
    private String userId;
    @DynamoDBRangeKey
    private String createdTimestamp;

}
