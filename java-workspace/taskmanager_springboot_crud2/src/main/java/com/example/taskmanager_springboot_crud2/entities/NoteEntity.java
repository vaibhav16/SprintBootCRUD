package com.example.taskmanager_springboot_crud2.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class NoteEntity {
    private int id;
    private String title;
    private String body;
}
