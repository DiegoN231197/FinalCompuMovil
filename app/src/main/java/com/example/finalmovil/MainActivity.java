package com.example.finalmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Registrar(View view){
        Intent intent = new Intent(this, Registrarse.class);
        startActivity(intent);
    }
    public void Ingresar(View view){
        Intent intent = new Intent(this, Menuprincipal.class);
        startActivity(intent);
    }

}