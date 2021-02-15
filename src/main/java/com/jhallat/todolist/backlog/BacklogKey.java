package com.jhallat.todolist.backlog;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Data;

@Data
public class BacklogKey {

    @DynamoDBHashKey
    private String userId;
    @DynamoDBRangeKey
    private String createdTimestamp;

}
