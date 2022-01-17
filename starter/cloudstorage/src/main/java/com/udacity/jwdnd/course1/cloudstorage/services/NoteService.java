package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import com.udacity.jwdnd.course1.cloudstorage.Model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.Model.User;
import com.udacity.jwdnd.course1.cloudstorage.mappers.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper){
        this.noteMapper=noteMapper;
    }
    public List<Note> getNotes(){
        return noteMapper.getNotes();
    }

    public void addNote(NoteForm noteForm){
        Note newNote = new Note();
        newNote.setUserId(noteForm.getUserId());
        noteMapper.addNote(newNote);
    }

}
