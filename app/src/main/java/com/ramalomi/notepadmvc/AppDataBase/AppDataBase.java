package com.ramalomi.notepadmvc.AppDataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ramalomi.notepadmvc.interfaces.NoteDao;
import com.ramalomi.notepadmvc.models.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
