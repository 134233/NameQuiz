package no.hvl.dat153.namequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    protected Map<String, Object> actions = new HashMap<>();

    void prepareMenu() {
        addMenuItem("Quiz", QuizActivity.class);
        addMenuItem("Database", DatabaseActivity.class);
        addMenuItem("Add new character", AddActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    List<Person> persons = ((Database) this.getApplication()).getDatabase();
    boolean ans = persons.isEmpty();
        if (ans) {
        ((Database) this.getApplication()).addPerson(new Person("Donald", getDrawable(R.drawable.donald)));
        ((Database) this.getApplication()).addPerson(new Person("Dolly", getDrawable(R.drawable.dolly)));
        ((Database) this.getApplication()).addPerson(new Person("Anton", getDrawable(R.drawable.anton)));
    }

    prepareMenu();

    String[] keys = actions.keySet().toArray(new String[actions.keySet().size()]);

    ListView av = (ListView) findViewById(R.id.menu_list);
    ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, keys);

    av.setAdapter(adapter);
        av.setOnItemClickListener((parent, view, position, id) -> {
        String key = (String) parent.getItemAtPosition(position);
        MainActivity.this.startActivity((Intent) actions.get(key));
    });
}

    public void addMenuItem(String label, Class<?> cls) {
        actions.put(label, new Intent(this, cls));
    }
}