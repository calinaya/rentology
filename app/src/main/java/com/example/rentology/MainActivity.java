package com.example.rentology;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        Button log = findViewById(R.id.login);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = user.getText().toString();
                String Pass = pass.getText().toString();

                if (User.isEmpty() || Pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (User.equals("landlord") && Pass.equals("landlord12345")){
                        Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,landlord_homepage.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }
             }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}