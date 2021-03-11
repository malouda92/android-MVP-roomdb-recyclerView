package com.ramalomi.notepadmvc.list;

import android.content.Context;

import com.ramalomi.notepadmvc.repositories.NoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ListPresenterModule {

    @Provides
    @Singleton
    ListPresenter provideListPresenter(ListPresenter.View view, Context context) {
        return new ListPresenter(view, new NoteRepository(context));
    }
}
