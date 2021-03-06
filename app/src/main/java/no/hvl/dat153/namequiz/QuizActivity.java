package no.hvl.dat153.namequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    ImageView personImage;
    EditText answerText;
    Button button;
    TextView scoreValue;
    TextView answerLabel;
    private Person  person;
    public static int score;
    private int maxScore;
    private Iterator<Person> personIterator;
    public static List<Person> persons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Find view
        personImage = findViewById(R.id.personImage);
        answerText = findViewById(R.id.answerText);
        button = findViewById(R.id.quizButton);
        scoreValue = findViewById(R.id.scoreValue);
        answerLabel = findViewById(R.id.answerLabel);

        score = 0;
        maxScore = 0;

        // Bind button
        button.setOnClickListener(v -> checkAnswer());

        // Shuffle DB
        PersonDatabase personDatabase = PersonDatabase.getInstance(this);
        persons = personDatabase.personDAO().getAll();
        Collections.shuffle(persons);
        personIterator = persons.iterator();

        newPerson();
    }

    public void newPerson() {
        // As long as there is more people in the database, else display end information
        if (personIterator.hasNext()) {
            person = personIterator.next();
            personImage.setImageDrawable(person.getImage());
        } else {
            setContentView(R.layout.quiz_finished);

            TextView endScoreValue = findViewById(R.id.endScoreValue);
            Button homeButton = findViewById(R.id.endQuizHomeButton);
            Button newQuizButton = findViewById(R.id.endQuizNewQuiz);

            endScoreValue.setText(score + " / " + maxScore);

            homeButton.setOnClickListener(v -> endQuiz());
            newQuizButton.setOnClickListener(v -> newQuiz());
        }
        answerText.setText("");
        answerText.onEditorAction(EditorInfo.IME_ACTION_DONE);
    }

    public void checkAnswer(){
        maxScore++;
        String submittedAnswer = answerText.getText().toString();
        String correctAnswer = person.getName();

        if(submittedAnswer.toLowerCase().equals(correctAnswer.toLowerCase())) {
            score++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong, the name is: " + correctAnswer, Toast.LENGTH_SHORT).show();
        }

        // Update score
        scoreValue.setText(score + " / " + maxScore);

        answerText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        newPerson();
    }

    // Onclick for Home
    public void endQuiz(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // onClick for Try Again
    public void newQuiz(){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
