package com.jhallat.todolist.idea;

import com.jhallat.todolist.timestamp.TimestampGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class IdeaController {

    //TODO Replace with user id from client
    private static final String DEFAULT_USER_ID = "jhallat";
    private final IdeaRepository ideaRepository;
    private final TimestampGenerator timestampGenerator;

    @GetMapping("/ideas")
    public List<Idea> getIdeas() {
        return ideaRepository.findAllByUserId(DEFAULT_USER_ID);
    }

    @PostMapping("/idea")
    public Idea addIdea(@RequestBody Idea idea) {
        if (StringUtils.isEmpty(idea.getUserId())) {
            idea.setUserId(DEFAULT_USER_ID);
        }
        if (StringUtils.isEmpty(idea.getCreatedTimestamp())) {
            idea.setCreatedTimestamp(timestampGenerator.generateFromNow());
        }
        return ideaRepository.save(idea);
    }

    @DeleteMapping("/idea/{userId}/{createdTimestamp}")
    public void deleteIdea(@PathVariable String userId, @PathVariable String createdTimestamp) {
        IdeaKey key = new IdeaKey();
        key.setUserId(userId);
        key.setCreatedTimestamp(createdTimestamp);
        ideaRepository.deleteById(key);
    }

}
