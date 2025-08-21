package com.pabloalan.task_manager_api.controller.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    @NotBlank
    @Size(max = 150)
    private String name;

    @NotNull
    @FutureOrPresent(message = "A data de entrega não pode estar no passado")
    private LocalDate dueDate;

    @NotBlank
    @Size(max = 120)
    private String assignee;
}
