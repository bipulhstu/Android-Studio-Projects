package com.bipul.example.firebaserealtimedatabaseretrievedata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<Student> studentList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listView = (ListView) findViewById(R.id.listViewId);
        studentList = new ArrayList<>();
        customAdapter = new CustomAdapter(DetailsActivity.this, studentList);
        databaseReference = FirebaseDatabase.getInstance().getReference("students");
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                studentList.clear();

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    Student student = dataSnapshot1.getValue(Student.class);
                    studentList.add(student);
                }

                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });
        super.onStart();
    }
}
