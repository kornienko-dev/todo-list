package com.kornienko.dao;

import com.kornienko.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer>, PagingAndSortingRepository<Task, Integer> {

}
