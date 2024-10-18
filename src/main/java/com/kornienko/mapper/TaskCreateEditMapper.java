package com.kornienko.mapper;

import com.kornienko.domain.Task;
import com.kornienko.dto.TaskCreateEditDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskCreateEditMapper {

    @Mapping(target = "id", ignore = true)
    Task map(TaskCreateEditDto from, @MappingTarget Task to);

    @Mapping(target = "id", ignore = true)
    Task map(TaskCreateEditDto from);
}
