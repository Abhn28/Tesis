package com.andrea.floodwarning;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Confirmacion2 extends AppCompatActivity {

    Button btnSgte;
    EditText editarNombreRio;
    //declaro variables que voy a mostrar
    TextView tvRioIngresado, tvTelefonoIngresado;
    private static  final String TAG = Confirmacion2.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion2);

        Bundle parametros = getIntent().getExtras();

        String rio      = parametros.getString("rio");
        String telefono = parametros.getString("telefono");

        tvRioIngresado = (TextView) findViewById(R.id.tvRioIngresado);
        tvTelefonoIngresado = (TextView) findViewById(R.id.tvTelefonoIngresado);

        tvRioIngresado.setText(rio);
        tvTelefonoIngresado.setText(telefono);

    }

    //Alerta para confirmar datos
    @Override
    public void onBackPressed() {
        Log.v(TAG, "onBackPressed");
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("¿Desea modificar los datos?");
        builder.setTitle(" ");
        builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                intent = new Intent(Confirmacion2.this,MainActivity.class);
                //con estas líneas se finaliza el activity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });



        AlertDialog dialog = builder.create();
        dialog.show();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent= new Intent(this,About.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent intent1= new Intent(this,Settings.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
