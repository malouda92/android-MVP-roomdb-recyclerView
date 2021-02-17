package com.ramalomi.notepadmvc.list;

import android.content.Context;

import com.ramalomi.notepadmvc.models.Note;
import com.ramalomi.notepadmvc.repositories.NoteRepository;

import java.util.List;

public class ListPresenter {

    private View view;
    private NoteRepository noteRepository;
    private List<Note> notes;

    public ListPresenter(View view, Context context) {
        this.view = view;
        noteRepository = new NoteRepository(context);
    }

    public void getAll() {
        notes = noteRepository.findAll();
        view.showNoteList(notes);
    }

    public interface View {
        void showNoteList(List<Note> notes);
    }
}
