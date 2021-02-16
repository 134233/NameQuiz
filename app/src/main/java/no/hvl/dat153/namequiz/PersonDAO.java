package no.hvl.dat153.namequiz;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import no.hvl.dat153.namequiz.Person;

@Dao
public interface PersonDAO {
    @Insert
    void addPerson(Person person);

    @Delete
    void deletePerson(Person person);

    @Query("SELECT * FROM person")
    List<Person> getAll();

    @Query("SELECT * FROM person WHERE uid IN (:personIds)")
    List<Person> loadAllByIds(int[] personIds);
}
