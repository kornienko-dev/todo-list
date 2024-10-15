package com.kornienko.mapper;

import com.kornienko.domain.Task;
import com.kornienko.dto.TaskCreateEditDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TaskCreateEditMapper {

    @Mapping(target = "id", ignore = true)
    Task map(TaskCreateEditDto from, Task to);

    @Mapping(target = "id", ignore = true)
    Task map(TaskCreateEditDto from);
}
