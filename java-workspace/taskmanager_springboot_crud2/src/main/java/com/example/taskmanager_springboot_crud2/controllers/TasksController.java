package com.example.taskmanager_springboot_crud2.controllers;

import com.example.taskmanager_springboot_crud2.dto.CreateTaskDTO;
import com.example.taskmanager_springboot_crud2.dto.ErrorResponseDTO;
import com.example.taskmanager_springboot_crud2.dto.UpdateTaskDTO;
import com.example.taskmanager_springboot_crud2.entities.TaskEntity;
import com.example.taskmanager_springboot_crud2.service.NotesService;
import com.example.taskmanager_springboot_crud2.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    private final NotesService notesService;

    public TasksController(TaskService taskService, NotesService notesService) {
        this.taskService = taskService;
        this.notesService = notesService;

    }



    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TaskEntity> getTaskById(@PathVariable ("id") Integer id){
        var task = taskService.getTasksById(id);
        var notes = notesService.getNotesForTask(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }

        task.setNotes(notes);

        return ResponseEntity.ok(task);
    }
    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException {
        var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(ParseException.class)
    public  ResponseEntity<ErrorResponseDTO> handleErrors(Exception e){
        if(e instanceof ParseException){
            return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage()));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable ("id") Integer id, @RequestBody UpdateTaskDTO body) throws ParseException {
        var task = taskService.updateTask(id, body.getTitle(), body.getDescription(), body.getDeadline(), body.getCompleted());
                if(task == null){
                    return ResponseEntity.notFound().build();

                }

                return ResponseEntity.ok(task);
    }


}
