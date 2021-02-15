package com.jhallat.todolist.backlog;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName="to-do-list.backlogs")
public class Backlog {
    
    @Id
    private BacklogKey backlogKey;
    private String description;
    private boolean ongoing;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return backlogKey != null ? backlogKey.getUserId() : null;
    }

    public void setUserId(String userId) {
        if (backlogKey == null) {
            backlogKey = new BacklogKey();
        }
        backlogKey.setUserId(userId);
    }

    @DynamoDBRangeKey(attributeName = "createdTimestamp")
    public String getCreatedTimestamp() {
        return backlogKey != null ? backlogKey.getCreatedTimestamp() : null;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        if (backlogKey == null) {
            backlogKey = new BacklogKey();
        }
        backlogKey.setCreatedTimestamp(createdTimestamp);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOngoing() { return ongoing; }

    public void setOngoing(boolean ongoing) { this.ongoing = ongoing; }

    @Override
    public String toString() {

        return String.format(""" 
            {
                userId: %s,
                createdTimestamp: %s,
                description: %s,
                onGoing: %s
            }
        """, this.getUserId(), this.getCreatedTimestamp(), this.getDescription(), this.isOngoing());

    }
}
