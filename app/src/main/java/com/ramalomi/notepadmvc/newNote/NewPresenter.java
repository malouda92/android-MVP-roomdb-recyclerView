package com.ramalomi.notepadmvc.newNote;

import android.content.Context;
import android.text.TextUtils;

import com.ramalomi.notepadmvc.models.Note;
import com.ramalomi.notepadmvc.repositories.NoteRepository;

public class NewPresenter {

    private View view;
    private NoteRepository noteRepository;
    private Note note;

    public NewPresenter(View view, Context context) {
        this.view = view;
        this.noteRepository = new NoteRepository(context);
        this.note = new Note();
    }

    public void createNote(String n) {
        if(TextUtils.isEmpty(n)) {
            view.onSaveError();
        }else {
            this.note.setTitle(n);
            this.note.setNote(n);
            this.noteRepository.persist(note);
            view.onSaveSuccess();
        }
    }

    public interface View {
        void onSaveSuccess();
        void onSaveError();
    }
}
