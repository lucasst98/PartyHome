package com.example.partyhome;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.content.ContentValues;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tela2Activity extends AppCompatActivity {
    EditText edit_text_login;
    EditText edit_text_password;
    AppCompatButton btn_Cadastro;
    SQLiteDatabase db;
    AppCompatButton btn_bd;
    Intent bdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        btn_bd = (AppCompatButton) findViewById(R.id.btn_Cadastro);
        btn_bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bdd = new Intent(Tela2Activity.this,AplicacaoBancoDeDados.class);
                startActivity(bdd);
            }
        });

        btn_Cadastro = (AppCompatButton) findViewById(R.id.btn_Cadastro);

        edit_text_login = (EditText) findViewById(R.id.edit_text_login);
        edit_text_password = (EditText) findViewById(R.id.edit_text_password);


        try {
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
        }
        catch (Exception e) {
            MostraMensagem("Erro :" +e.toString());
        }

        btn_Cadastro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View args0) {
                MostraMensagem("Dados cadastrados com sucesso");
                String login  = edit_text_login.getText().toString();
                String senha = edit_text_password.getText().toString();

                ContentValues valor = new ContentValues();

                valor.put("login", login);
                valor.put("senha", senha);



                try {

              db.insert("usuarios",null,valor);
                MostraMensagem("Dados cadastrado com sucesso!!");
                }
                catch (Exception e) {
                    MostraMensagem("Erro" + e.toString());

                }
            }
        });
    }
    public void MostraMensagem (String str){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(Tela2Activity.this);

        dialogo.setTitle("Aviso");
                dialogo.setMessage(str);
                dialogo.setNeutralButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      Tela2Activity.this.finish();
                    }
                });

    }
}



