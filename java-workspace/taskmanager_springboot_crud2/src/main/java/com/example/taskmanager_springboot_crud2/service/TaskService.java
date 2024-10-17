package com.example.taskmanager_springboot_crud2.service;

import com.example.taskmanager_springboot_crud2.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    private final SimpleDateFormat deadlineFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public TaskEntity addTask(String title, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadlineFormatter.parse(deadline)); //ToDo validate date format
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;

    }

    public ArrayList<TaskEntity> getTasks(){return tasks;}

    public TaskEntity getTasksById(int id){
        for(TaskEntity task: tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }


    public TaskEntity updateTask(int id, String title, String description, Date deadline, Boolean completed) throws ParseException {
        TaskEntity task = getTasksById(id);

        if(task==null){
            return null;
        }

        if(title != null){
            task.setTitle(title);
        }

        if(description != null){
            task.setDescription(description);
        }

        if(deadline != null){
            task.setDeadline(deadline);
        }

        if(completed != null){
            task.setCompleted(completed);
        }

        return task;
    }
}
