package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.Model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }
    @GetMapping
    public String getNotePage(NoteForm noteForm, Model model){
        model.addAttribute("newNote",noteForm);
        model.addAttribute("allNotes", this.noteService.getNotes());
        return "home/#nav-notes";
    }
    @PostMapping
    public String postNewNote(Authentication authentication, NoteForm noteForm, Model model){
        noteForm.setUsername(authentication.getName());
        this.noteService.addNote(noteForm);
        noteForm.setNoteTitle("");
        noteForm.setNoteDescription("");
        model.addAttribute("noteForm",this.noteService.getNotes());
        return "home";
    }
}
