package com.kornienko.dto;

import com.kornienko.domain.Status;
import com.kornienko.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Task}
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateEditDto implements Serializable {

    String description;
    Status status;
}
