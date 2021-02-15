package com.jhallat.todolist.backlog;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface BacklogRepository extends CrudRepository<Backlog, BacklogKey> {
    List<Backlog> findAllByUserId(String userId);
}
