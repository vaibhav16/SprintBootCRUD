package com.example.taskmanager_springboot_crud2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateNoteDTO {
    private String title;
    private String body;
}
