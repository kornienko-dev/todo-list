package com.kornienko.mapper;

import com.kornienko.domain.Task;
import com.kornienko.dto.TaskReadDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskReadMapper {

    TaskReadDto map(Task from);
}
