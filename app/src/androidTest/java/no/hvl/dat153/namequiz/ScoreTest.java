package no.hvl.dat153.namequiz;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ScoreTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void rightAnswer(){
        if (!QuizActivity.persons.isEmpty()) {
            String name = QuizActivity.persons.get(0).getName();
            assertThat(QuizActivity.score, equalTo(0));
            onView(withId(R.id.answerText)).perform(typeText(name), ViewActions.closeSoftKeyboard());
            onView(withId(R.id.quizButton)).perform(click());
            assertThat(QuizActivity.score, equalTo(1));
        }
    }

    @Test
    public void wrongAnswer(){
        if (!QuizActivity.persons.isEmpty()) {
            assertThat(QuizActivity.score, equalTo(0));
            onView(withId(R.id.answerText)).perform(typeText("Wrong"), ViewActions.closeSoftKeyboard());
            onView(withId(R.id.quizButton)).perform(click());
            assertThat(QuizActivity.score, equalTo(0));
        }
    }
}
