package com.example.partyhome;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.ContentValues;

public class AplicacaoBancoDeDados extends AppCompatActivity {
    AppCompatButton btn_bed;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacao_banco_de_dados);
        btn_bed = findViewById(R.id.btn_bed);
        btn_bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE,
                            null);
                    db.execSQL("create table if not exists  usuarios (numreg integer primary key"+
                            " autoincrement, login text not null, senha text not null)");
                    AlertDialog.Builder dialogo = new
                            AlertDialog.Builder(AplicacaoBancoDeDados.this);
                    dialogo.setTitle("Aviso")
                            .setMessage("Banco de dados criado com sucesso!!")
                            .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AplicacaoBancoDeDados.this.finish();
                                }
                            })
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}