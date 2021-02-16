package no.hvl.dat153.namequiz;

import android.graphics.drawable.Drawable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    private String name;
    private Drawable image;

    public Person(String name, Drawable image) {
        this.name = name;
        this.image = image;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Drawable getImage() { return image; }

    // public void setImage(Drawable image) { this.image = image; }
}
