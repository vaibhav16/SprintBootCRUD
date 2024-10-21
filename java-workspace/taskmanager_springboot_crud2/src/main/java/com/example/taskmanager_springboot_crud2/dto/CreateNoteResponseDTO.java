package com.example.taskmanager_springboot_crud2.dto;

import com.example.taskmanager_springboot_crud2.entities.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CreateNoteResponseDTO {

    private Integer taskId;
    private NoteEntity note;
}
