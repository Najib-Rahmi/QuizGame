package com.example.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Quiz> questions;

    public ListAdapter(Context context, ArrayList<Quiz> objects)
    {
        super(context, 0, objects);
        this.questions=objects; this.context=context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;


            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_row, null);

            TextView question = (TextView) v.findViewById(R.id.question);
            TextView reponse1 = (TextView) v.findViewById(R.id.reponse1);
            TextView reponse2 = (TextView) v.findViewById(R.id.reponse2);
            TextView reponse3 = (TextView) v.findViewById(R.id.reponse3);
            TextView bonnereponse = (TextView) v.findViewById(R.id.bonnereponse);

            question.setText(questions.get(position).getQuestion());
            reponse1.setText(questions.get(position).getReponse1());
            reponse2.setText(questions.get(position).getReponse2());
            reponse3.setText(questions.get(position).getReponse3());
            bonnereponse.setText(questions.get(position).getBonneReponse());

        return v;
    }
}
