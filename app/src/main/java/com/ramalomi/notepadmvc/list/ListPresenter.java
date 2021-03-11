package com.ramalomi.notepadmvc.list;

import android.content.Context;

import com.ramalomi.notepadmvc.models.Note;
import com.ramalomi.notepadmvc.repositories.NoteRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;

public class ListPresenter {

    private View view;
    private NoteRepository noteRepository;
    private List<Note> notes;

    @Inject
    public ListPresenter(View view, NoteRepository noteRepository) {
        this.view = view;
        this.noteRepository = noteRepository;
    }

    public void getAll() {
        notes = noteRepository.findAll();
        view.showNoteList(notes);
    }

    public interface View {
        void showNoteList(List<Note> notes);
    }
}
