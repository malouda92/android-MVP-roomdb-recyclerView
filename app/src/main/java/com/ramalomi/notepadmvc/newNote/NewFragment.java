package com.ramalomi.notepadmvc.newNote;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ramalomi.notepadmvc.MainActivity;
import com.ramalomi.notepadmvc.R;


public class NewFragment extends Fragment implements NewPresenter.View {

    EditText note_txt;
    NewPresenter newPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        setHasOptionsMenu(true);
        note_txt = view.findViewById(R.id.note_txt);
        newPresenter = new NewPresenter(this, getContext());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.check_item) {
            newPresenter.createNote(note_txt.getText().toString());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveSuccess() {
        Toast.makeText(getContext(), "Note sauvegardé", Toast.LENGTH_LONG).show();
        getActivity().onBackPressed();
    }

    @Override
    public void onSaveError() {
        Toast.makeText(getContext(), "Erreur de sauvegarde", Toast.LENGTH_SHORT).show();
    }
}