package com.ramalomi.notepadmvc.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ramalomi.notepadmvc.AppDataBase.AppDataBase;
import com.ramalomi.notepadmvc.MainActivity;
import com.ramalomi.notepadmvc.R;
import com.ramalomi.notepadmvc.adapters.NoteAdapter;
import com.ramalomi.notepadmvc.interfaces.NoteDao;
import com.ramalomi.notepadmvc.models.Note;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;


public class ListFragment extends Fragment implements ListPresenter.View {

    @Inject
    ListPresenter listPresenter;
    private RecyclerView recyclerView;
    private NavController navController;
    private FloatingActionButton fab;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        setHasOptionsMenu(true);
        ListPresenterComponent listPresenterComponent = DaggerListPresenterComponent.builder().withView(this).withContext(getContext()).build();
        listPresenterComponent.inject(this);
        recyclerView = view.findViewById(R.id.recyclerView);
        fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(ListFragmentDirections.actionListFragmentToNewFragment());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        listPresenter.getAll();
    }

    @Override
    public void showNoteList(List<Note> notes) {
        List<String> list_title = new ArrayList<>();
        Iterator<Note> noteIterator = notes.iterator();
        while(noteIterator.hasNext()) {
            Note note = noteIterator.next();
            list_title.add(note.getTitle());
        }
        NoteAdapter noteAdapter = new NoteAdapter(list_title);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }
}