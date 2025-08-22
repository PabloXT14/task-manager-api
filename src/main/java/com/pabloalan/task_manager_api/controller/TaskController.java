package com.pabloalan.task_manager_api.controller;

import com.pabloalan.task_manager_api.controller.dto.TaskRequest;
import com.pabloalan.task_manager_api.controller.dto.TaskResponse;
import com.pabloalan.task_manager_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;


    // Criar
    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskRequest body) {
        TaskResponse taskCreated = taskService.create(body);

        // Alternativa caso queira retornar para uma rota específica de listagem por id da tarefa
        // return ResponseEntity.created(URI.create("/api/tasks/" + taskCreated.getId())).body(taskCreated);

        return ResponseEntity.status(201).body(taskCreated);
    }

    // Buscar todos
    @GetMapping
    public ResponseEntity<List<TaskResponse>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@PathVariable Long id, @Valid @RequestBody TaskRequest body) {
        return ResponseEntity.ok(taskService.update(id, body));
    }

    // Deletar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
