package no.hvl.dat153.namequiz;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat153.namequiz.R;

public class Database extends Application {
    private List<Person> database;


    @Override
    public void onCreate() {
        super.onCreate();
        database.add(new Person("Donald", getDrawable(R.drawable.donald)));
        database.add(new Person("Dolly", getDrawable(R.drawable.dolly)));
        database.add(new Person("Anton", getDrawable(R.drawable.anton)));
    }

    public Database (){
        database = new ArrayList<>();
    }
    public List<Person> getDatabase() {
        return database;
    }

    public void addPerson(Person person) {
        this.database.add(person);
    }
}
