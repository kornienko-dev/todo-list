package com.kornienko.dto;

import com.kornienko.domain.Status;
import com.kornienko.domain.Task;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Task}
 */
@Value
public class TaskCreateEditDto implements Serializable {

    String description;
    Status status;
}
