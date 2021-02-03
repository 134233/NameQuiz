package no.hvl.dat153.namequiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import no.hvl.dat153.namequiz.Person;
import no.hvl.dat153.namequiz.R;

public class DbAdapter extends ArrayAdapter<Person> {

    private Context context;
    private int resources;

    public DbAdapter (@NonNull Context context, int resources, @NonNull ArrayList<Person> persons) {
        super(context, resources, persons);
        this.context = context;
        this.resources = resources;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        view = layoutInflater.inflate(this.resources, parent, false);

        //Image
        ImageView imageView = view.findViewById(R.id.imageViewPerson);
        imageView.setImageDrawable(getItem(position).getImage());

        //Name
        TextView textView = view.findViewById(R.id.textViewName);
        textView.setText(getItem(position).getName());

        return view;
    }

}
