package com.kornienko.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class TaskControllerTest extends AbstractTest {

    @SneakyThrows
    @Test
    void findAll() {
        mockMvc.perform(get("/"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("tasks"))
                .andExpect(model().attributeExists("tasks"));
    }

    @SneakyThrows
    @Test
    void create() {
        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "description": "test",
                                  "status": "IN_PROGRESS"
                                }
                                """))
                .andExpect(status().is2xxSuccessful());
    }
}