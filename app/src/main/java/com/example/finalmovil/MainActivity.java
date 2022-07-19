package com.example.finalmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
        Intent intent = new Intent(this, prueba.class);
        String name="andres";
        String lastname="diaz";
        Integer number=2;
        Map<String, Object> user= new HashMap<>();
        user.put("nombre", name);
        user.put("apellido", lastname);
        db.collection("Usuarios").document("2").set(user);
        startActivity(intent);
    }


}