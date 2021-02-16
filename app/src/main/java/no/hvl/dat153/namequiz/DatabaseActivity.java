package no.hvl.dat153.namequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import no.hvl.dat153.namequiz.DbAdapter;
import no.hvl.dat153.namequiz.R;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat153.namequiz.Database;
import no.hvl.dat153.namequiz.Person;

public class DatabaseActivity extends AppCompatActivity {

    private ListView listView;
    private PersonDatabase personDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        listView = findViewById(R.id.dbList);

        personDatabase = personDatabase.getInstance(this);

        List<Person> persons = personDatabase.personDAO().getAll();

        DbAdapter databaseAdapter = new DbAdapter(this, R.layout.dbrow, persons);

        listView.setAdapter(databaseAdapter);
    }

    public void addNewPerson(View view) {
        Intent i = new Intent(this, AddActivity.class);
        startActivity(i);
    }
}
