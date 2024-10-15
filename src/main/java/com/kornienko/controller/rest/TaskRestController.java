package com.kornienko.controller.rest;

import com.kornienko.domain.Task;
import com.kornienko.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskRestController {

    private TaskService taskService;

    @GetMapping
    public List<Task> getAll() {
        return taskService.findAll();
    }
}
