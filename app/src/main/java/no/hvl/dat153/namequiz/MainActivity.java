package no.hvl.dat153.namequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import no.hvl.dat153.namequiz.Database;
import no.hvl.dat153.namequiz.Person;
import no.hvl.dat153.namequiz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quiz(View view) {
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }

    public void database(View view) {
        Intent i = new Intent(this, DatabaseActivity.class);
        startActivity(i);
    }

    public void add(View view) {
        Intent i = new Intent(this, AddActivity.class);
        startActivity(i);
    }
}