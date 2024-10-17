package com.example.taskmanager_springboot_crud2.controllers;

import com.example.taskmanager_springboot_crud2.dto.CreateTaskDTO;
import com.example.taskmanager_springboot_crud2.entities.TaskEntity;
import com.example.taskmanager_springboot_crud2.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TaskEntity> getTaskById(@PathVariable ("id") Integer id){
        var task = taskService.getTasksById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }
    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body){
        var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }
}
