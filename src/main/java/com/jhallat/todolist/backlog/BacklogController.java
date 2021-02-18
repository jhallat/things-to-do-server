package com.jhallat.todolist.backlog;

import com.jhallat.todolist.idea.Idea;
import com.jhallat.todolist.idea.IdeaKey;
import com.jhallat.todolist.timestamp.TimestampGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class BacklogController {

    //TODO Replace with user id from client
    private static final String DEFAULT_USER_ID = "jhallat";
    private final BacklogRepository backlogRepository;
    private final TimestampGenerator timestampGenerator;

    @GetMapping("/backlogs")
    public List<Backlog> getBacklogs() {
        return backlogRepository.findAllByUserId(DEFAULT_USER_ID);
    }

    @PostMapping("/backlog")
    public Backlog addIdea(@RequestBody @Valid Backlog backlog) {
        if (StringUtils.isEmpty(backlog.getUserId())) {
            backlog.setUserId(DEFAULT_USER_ID);
        }
        if (StringUtils.isEmpty(backlog.getCreatedTimestamp())) {
            backlog.setCreatedTimestamp(timestampGenerator.generateFromNow());
        }
        return backlogRepository.save(backlog);
    }

    @DeleteMapping("/backlog/{userId}/{createdTimestamp}")
    public void deleteBacklog(@PathVariable String userId, @PathVariable String createdTimestamp) {
        BacklogKey key = new BacklogKey();
        key.setUserId(userId);
        key.setCreatedTimestamp(createdTimestamp);
        backlogRepository.deleteById(key);
    }
}
