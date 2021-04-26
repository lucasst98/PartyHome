
package com.example.partyhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn_registro;
    Intent itela2;
    AppCompatButton btn_Login;
    Intent login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Login = (AppCompatButton) findViewById(R.id.btn_Login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(login);
            }
        });
       btn_registro = (AppCompatButton) findViewById(R.id.btn_registro);
       btn_registro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               itela2 = new Intent(MainActivity.this,Tela2Activity.class);
               startActivity(itela2);


           }
       });

    }
}
