package no.hvl.dat153.namequiz;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import no.hvl.dat153.namequiz.DbAdapter;
import no.hvl.dat153.namequiz.R;

import java.util.ArrayList;

import no.hvl.dat153.namequiz.Database;
import no.hvl.dat153.namequiz.Person;

public class DatabaseActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        listView = findViewById(R.id.dbList);

        ArrayList<Person> persons = ((Database) this.getApplication()).getDatabase();

        DbAdapter databaseAdapter = new DbAdapter(this, R.layout.dbrow, persons);

        listView.setAdapter(databaseAdapter);

    }
}
