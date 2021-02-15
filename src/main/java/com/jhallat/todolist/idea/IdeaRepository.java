package com.jhallat.todolist.idea;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface IdeaRepository extends CrudRepository<Idea, IdeaKey> {
    List<Idea> findAllByUserId(String userId);
}
