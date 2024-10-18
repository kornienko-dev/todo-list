package com.kornienko.controller;

import com.kornienko.dto.TaskCreateEditDto;
import com.kornienko.dto.TaskReadDto;
import com.kornienko.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.IntStream;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String findAll(Model model,
                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                          @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit) {
        Page<TaskReadDto> tasks = taskService.findAll(PageRequest.of(page, limit));
        model.addAttribute("tasks", tasks);
        if (tasks.getTotalPages() > 1) {
            List<Integer> pageNumbers = IntStream.range(0, tasks.getTotalPages()).boxed().toList();
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "tasks";
    }

    @PutMapping("/{id}")
    public String update(Model model,
                         @PathVariable(name = "id") Integer id,
                         @RequestBody TaskCreateEditDto task) {
        return taskService.update(id, task)
                .map(taskDto -> redirectToFindAll(model))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String create(Model model,
                         @RequestBody TaskCreateEditDto task) {
        taskService.create(task);
        return redirectToFindAll(model);
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable(name = "id") Integer id) {
        if (!taskService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return redirectToFindAll(model);
    }

    private String redirectToFindAll(Model model) {
        return findAll(model, 1, 10);
    }
}
