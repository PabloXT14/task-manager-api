package com.pabloalan.task_manager_api.domain.repository;

import com.pabloalan.task_manager_api.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
