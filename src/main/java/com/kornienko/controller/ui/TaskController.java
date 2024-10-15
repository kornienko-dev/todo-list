package com.kornienko.controller.ui;

import com.kornienko.domain.Task;
import com.kornienko.dto.PageResponse;
import com.kornienko.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String findAll(Model model, Pageable pageable) {
        Page<Task> page = taskService.findAll(pageable);
        model.addAttribute("tasks", PageResponse.of(page));
        return "index";
    }
}
