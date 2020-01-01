package com.bipul.example.firebaserealtimedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText, ageEditText;
    private Button saveDataButton;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        nameEditText = (EditText) findViewById(R.id.nameEditTextid);
        ageEditText = (EditText) findViewById(R.id.ageEditTextid);
        saveDataButton = (Button) findViewById(R.id.saveDataButtonId);

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });
    }
    public void saveData(){

        String name = nameEditText.getText().toString().trim();
        String age = ageEditText.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Student student = new Student(name, age);

        databaseReference.child(key).setValue(student);

        Toast.makeText(getApplicationContext(), "Student info is successfully added", Toast.LENGTH_SHORT).show();

        nameEditText.setText("");
        ageEditText.setText("");



    }
}
