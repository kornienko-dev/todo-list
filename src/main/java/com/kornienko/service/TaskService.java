package com.kornienko.service;

import com.kornienko.dao.TaskDao;
import com.kornienko.domain.Task;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private TaskDao taskDao;

    public Page<Task> findAll(Pageable pageable) {
        return taskDao.findAll(pageable);
    }

    public List<Task> findAll() {
        return (List<Task>) taskDao.findAll();
    }
}
