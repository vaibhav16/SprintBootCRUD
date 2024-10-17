package com.example.taskmanager_springboot_crud2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTaskDTO {
    String title;
    String description;
    Date deadline;
    Boolean completed;

}
