package com.example.taskmanager_springboot_crud2.entities;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;
    private List<NoteEntity> notes;
}
