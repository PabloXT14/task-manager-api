package com.pabloalan.task_manager_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class TaskResponse {
    private Long id;
    private String name;
    private LocalDate dueDate;
    private String assignee;
}
