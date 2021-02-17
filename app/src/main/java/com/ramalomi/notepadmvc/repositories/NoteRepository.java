package com.ramalomi.notepadmvc.repositories;

import android.content.Context;

import androidx.room.Room;

import com.ramalomi.notepadmvc.AppDataBase.AppDataBase;
import com.ramalomi.notepadmvc.interfaces.NoteDao;
import com.ramalomi.notepadmvc.models.Note;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;

    public NoteRepository(Context context) {
        AppDataBase appDB = Room.databaseBuilder(context,
                AppDataBase.class, "database-name").allowMainThreadQueries().build();
        noteDao = appDB.noteDao();
    }

    public void persist(Note note) {
        noteDao.insert(note);
    }

    public List<Note> findAll() {
        return noteDao.getAllNote();
    }
}
