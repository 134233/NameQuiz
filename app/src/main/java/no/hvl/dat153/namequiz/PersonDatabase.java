package no.hvl.dat153.namequiz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Person.class}, version = 6)
@TypeConverters({Convert.class})
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDAO personDAO();
    public static PersonDatabase INSTANCE;

    public static PersonDatabase getInstance(Context context){
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PersonDatabase.class, "personDatabase").
                    fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public PersonDAO getPersonDAO() {
        return personDAO();
    }
}
