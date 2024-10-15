package com.kornienko.service;

import com.kornienko.dao.TaskDao;
import com.kornienko.domain.Task;
import com.kornienko.dto.TaskCreateEditDto;
import com.kornienko.dto.TaskReadDto;
import com.kornienko.mapper.TaskCreateEditMapper;
import com.kornienko.mapper.TaskReadMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    private final TaskDao taskDao;
    private final TaskCreateEditMapper taskCreateEditMapper;
    private final TaskReadMapper taskReadMapper;

    public List<TaskReadDto> findAll(Pageable pageable) {
        return taskDao.findAll(pageable).stream()
                .map(taskReadMapper::map)
                .toList();
    }

    public int findAllCount() {
        return Math.toIntExact(taskDao.count());
    }

    @Transactional
    public TaskReadDto create(TaskCreateEditDto taskDto) {
        return Optional.of(taskDto)
                .map(taskCreateEditMapper::map)
                .map(taskDao::save)
                .map(taskReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<TaskReadDto> update(Integer id, TaskCreateEditDto taskDto) {
        return taskDao.findById(id)
                .map(entity -> taskCreateEditMapper.map(taskDto, entity))
                .map(taskDao::saveAndFlush)
                .map(taskReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return taskDao.findById(id)
                .map(entity -> {
                    taskDao.delete(entity);
                    taskDao.flush();
                    return true;
                })
                .orElse(false);
    }
}
