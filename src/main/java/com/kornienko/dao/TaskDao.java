package com.kornienko.dao;

import com.kornienko.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends PagingAndSortingRepository<Task, Integer>, CrudRepository<Task, Integer> {

}
