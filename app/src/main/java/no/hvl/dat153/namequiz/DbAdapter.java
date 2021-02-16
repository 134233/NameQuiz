package no.hvl.dat153.namequiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat153.namequiz.PersonDatabase;
import no.hvl.dat153.namequiz.R;

public class DbAdapter extends ArrayAdapter<Person> {

    private Context context;
    private int resources;
    private PersonDatabase personDatabase;
    private List<Person> persons;

    public DbAdapter (@NonNull Context context, int resources, @NonNull List<Person> persons) {
        super(context, resources, persons);
        this.context = context;
        this.resources = resources;
        this.persons = persons;
        this.personDatabase = PersonDatabase.getInstance(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        view = layoutInflater.inflate(this.resources, parent, false);

        //Image
        ImageView imageView = view.findViewById(R.id.imageViewPerson);
        imageView.setImageDrawable(getItem(position).getImage());

        //Name
        TextView textView = view.findViewById(R.id.textViewName);
        textView.setText(getItem(position).getName());

        //Delete button
        Button deleteButton = view.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(v -> deletePerson(position));

        return view;
    }

    public void deletePerson(int pos){
        Person person = getItem(pos);
        remove(person);
        personDatabase.personDAO().deletePerson(person);
        Toast.makeText(context, "Successfully removed " + person.getName(), Toast.LENGTH_SHORT).show();
    }

}
