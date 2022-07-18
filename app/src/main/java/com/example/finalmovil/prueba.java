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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class prueba extends AppCompatActivity {

    ImageButton btncamara;
    ImageView fototomada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        btncamara = findViewById(R.id.btncamara);
        fototomada =findViewById(R.id.fototomada);

        btncamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
    }

    private void abrirCamara (){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent,1);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            fototomada.setImageBitmap(imgBitmap);
        }
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
    //Función para que el usuario no llegue al login mediante boton retroceder sde su dispositivo
    @Override
        public void onBackPressed(){

        }

    public void cerrar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



/*/ PRIMER INTENTO CÁMARA
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
    }/*/

}