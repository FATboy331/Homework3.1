package com.geektech.homework31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnClick;
    private EditText email;
    private EditText theme;
    private EditText message;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = findViewById(R.id.send);
        email = findViewById(R.id.email);
        theme = findViewById(R.id.theme);
        message = findViewById(R.id.message);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", email.getText().toString(), null));
                String text = message.getText().toString();
                emailIntent.putExtra(Intent.EXTRA_EMAIL, email.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "send"));
            }


        });

    }

}