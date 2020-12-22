package com.example.firebase_task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=BHT8hCtOP1U

    EditText regname, regemail, regpassword, regnumber;
    Button regsignup;

    FirebaseDatabase rootnode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regname = findViewById(R.id.name);
        regemail = findViewById(R.id.email);
        regpassword = findViewById(R.id.password);
        regnumber = findViewById(R.id.name);
        regsignup = findViewById(R.id.signup);


        regsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("user");

                String name = regname.getText().toString();
                String email = regname.getText().toString();
                String password = regname.getText().toString();
                String number = regname.getText().toString();


                UserHelperClass helperClass = new UserHelperClass(name, email, password, number);

                //child name  to use in id
                reference.child(name).setValue(helperClass);


                Toast.makeText(MainActivity.this, "Submit Data", Toast.LENGTH_SHORT).show();


            }
        });


    }
}