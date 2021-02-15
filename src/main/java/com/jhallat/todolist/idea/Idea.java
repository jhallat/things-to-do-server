package com.jhallat.todolist.idea;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;


@DynamoDBTable(tableName = "to-do-list.ideas")
public class Idea {

    @Id
    private IdeaKey ideaKey;
    private String description;

    @DynamoDBHashKey(attributeName = "userId")
    public String getUserId() {
        return ideaKey != null ? ideaKey.getUserId() : null;
    }

    public void setUserId(String userId) {
        if (ideaKey == null) {
            ideaKey = new IdeaKey();
        }
        ideaKey.setUserId(userId);
    }

    @DynamoDBRangeKey(attributeName = "createdTimestamp")
    public String getCreatedTimestamp() {
        return ideaKey != null ? ideaKey.getCreatedTimestamp() : null;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        if (ideaKey == null) {
            ideaKey = new IdeaKey();
        }
        ideaKey.setCreatedTimestamp(createdTimestamp);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
