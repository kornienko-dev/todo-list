package com.kornienko.controller;

import com.kornienko.dto.TaskCreateEditDto;
import com.kornienko.dto.TaskReadDto;
import com.kornienko.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String findAll(Model model,
                          @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                          @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        List<TaskReadDto> tasks = taskService.findAll(PageRequest.of(page, limit));
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/{id}")
    public void update(Model model,
                         @PathVariable Integer id,
                         @RequestBody TaskCreateEditDto task) {
        taskService.update(id, task)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void create(Model model,
                         @RequestBody TaskCreateEditDto task) {
        taskService.create(task);
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable Integer id) {
        if (!taskService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/tasks";
    }
}
