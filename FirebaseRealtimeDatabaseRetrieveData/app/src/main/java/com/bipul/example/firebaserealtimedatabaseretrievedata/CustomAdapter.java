package com.bipul.example.firebaserealtimedatabaseretrievedata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public CustomAdapter(Activity context, List<Student> studentList) {
        super(context, R.layout.sample_layout, studentList);
        this.context = context;
        this.studentList = studentList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout, null, true);

        Student student = studentList.get(position);


        TextView t1 = view.findViewById(R.id.nameTextViewId);
        TextView t2 = view.findViewById(R.id.ageTextViewId);


        t1.setText("Name: "+student.getName());
        t2.setText("Age: "+student.getAge());

        return view;
    }
}
