package no.hvl.dat153.namequiz;

import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DatabaseTest {

    private PersonDatabase personDatabase;
    private PersonDAO personDAO;
    private Context context;
    private Person donald;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void beforeEntryTest(){
        context = ApplicationProvider.getApplicationContext();
        personDatabase = Room.inMemoryDatabaseBuilder(context, PersonDatabase.class).build();
        personDAO = personDatabase.getPersonDAO();

        donald = new Person("Donald", ContextCompat.getDrawable(context, R.drawable.donald));

        personDAO.addPerson(donald);
    }

    @After
    public void afterEntryTest(){
        personDatabase.close();
    }

    @Test
    public void entryTest() {
        assertThat(personDAO   .getAll().size(), equalTo(1));
    }

    @Test
    public void removalTest() {
        personDAO.deletePerson(donald);
        assertThat(personDAO.getAll().size(), equalTo(1));
    }

}
