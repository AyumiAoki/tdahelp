package com.example.tdahelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class TelaMenu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);
        getSupportActionBar().hide();
    }

    public void memoria(View view){
        Intent intent = new Intent(getApplicationContext(), TelaMemoria.class);
        startActivity(intent);

    }

    public void quebraCabeca(View view){
        Intent intent = new Intent(getApplicationContext(), TelaQuebraCabeca.class);
        startActivity(intent);

    }

    public void colorir(View view){
        Intent intent = new Intent(getApplicationContext(), TelaColorir.class);
        startActivity(intent);

    }

}
