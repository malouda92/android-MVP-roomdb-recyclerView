package com.ramalomi.notepadmvc.list;

import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = ListPresenterModule.class)
public interface ListPresenterComponent {

    ListPresenter provideListPresenter();
    void inject(ListFragment listFragment);

    @Component.Builder
    interface Builder{

        @BindsInstance
        ListPresenterComponent.Builder withView(ListPresenter.View view);
        @BindsInstance
        ListPresenterComponent.Builder withContext(Context context);
        ListPresenterComponent build();
    }
}
