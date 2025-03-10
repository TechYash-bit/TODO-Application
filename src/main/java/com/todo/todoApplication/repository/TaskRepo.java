package com.todo.todoApplication.repository;

import com.todo.todoApplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
}
