package com.pabloalan.task_manager_api.service;

import com.pabloalan.task_manager_api.controller.dto.TaskRequest;
import com.pabloalan.task_manager_api.controller.dto.TaskResponse;
import com.pabloalan.task_manager_api.domain.entity.Task;
import com.pabloalan.task_manager_api.domain.repository.TaskRepository;
import com.pabloalan.task_manager_api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public TaskResponse create(TaskRequest dto) {
        Task t = new Task();

        t.setName(dto.getName());
        t.setDueDate(dto.getDueDate());
        t.setAssignee(dto.getAssignee());

        Task savedTask = taskRepository.save(t);

        return toResponse(savedTask);
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public TaskResponse findById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarefa não encontrada: id = " + id));

        return toResponse(task);
    }

    @Transactional
    public TaskResponse update(Long id, TaskRequest dto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarefa não encontrada: id = " + id));

        task.setName(dto.getName());
        task.setDueDate(dto.getDueDate());
        task.setAssignee(dto.getAssignee());

        Task updatedTask = taskRepository.save(task);

        return toResponse(updatedTask);
    }

    @Transactional
    public void delete(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new NotFoundException("Tarefa nao encontrada: id = " + id);
        }

        taskRepository.deleteById(id);
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId(), task.getName(), task.getDueDate(), task.getAssignee());
    }
}
