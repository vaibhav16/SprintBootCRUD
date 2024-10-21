package com.example.taskmanager_springboot_crud2.service;

import com.example.taskmanager_springboot_crud2.entities.NoteEntity;
import com.example.taskmanager_springboot_crud2.entities.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {
    private TaskService taskService;
    private HashMap<Integer, TaskNotesHolder> taskNoteHolders = new HashMap<>();
    public NotesService(TaskService taskService) {
        this.taskService = taskService;
    }
    class TaskNotesHolder{
        protected int noteId = 1;
        private ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTasksById(taskId);
        if(task ==null){
            return null;
        }

        if(taskNoteHolders.get(taskId) == null) {
            taskNoteHolders.put(taskId,new TaskNotesHolder());
        }

        return taskNoteHolders.get(taskId).notes;
    }

    public NoteEntity addNoteForTask(int taskId, String title, String body){
        TaskEntity task = taskService.getTasksById(taskId);

        if(task == null){
            return null;
        }

        if(taskNoteHolders.get(taskId) == null) {
            taskNoteHolders.put(taskId,new TaskNotesHolder());
        }

        TaskNotesHolder taskNoteHolder = taskNoteHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNoteHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNoteHolder.notes.add(note);
        taskNoteHolder.noteId++;
        return note;
    }
}

