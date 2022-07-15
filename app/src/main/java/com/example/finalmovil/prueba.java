package com.example.finalmovil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class prueba extends AppCompatActivity {

    ImageView fototomada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
    }
    // Método para mostrar y ocultar el menú
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menupantalla,menu);
        return true;
    }
    // Método para asignar las funciones correspondientesalas opciones.
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.igaleria){
            Toast.makeText(this,"Galeria de imagenes",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.ifoto){
            Toast.makeText(this,"Tomar fotografía",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.icerrars){
            Toast.makeText(this,"Sesión cerrada",Toast.LENGTH_SHORT).show();
            cerrar(null);
        }
        return super.onOptionsItemSelected(item);
    }

    public void cerrar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    static final int TOMAR_FOTO=1;
    public void tomarfoto(View view){
        Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,TOMAR_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TOMAR_FOTO && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap1 = (Bitmap) extras.get("data");
            fototomada.setImageBitmap(bitmap1);
            try {
                FileOutputStream fos = openFileOutput(guardarfoto(), Context.MODE_PRIVATE);
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,fos);
                fos.close();
            }catch (Exception e){
            }
         }
    }
    public String guardarfoto(){
        String fecha = new SimpleDateFormat("ddMMyyy").format(new Date());
        return fecha+".jpg";
    }

}