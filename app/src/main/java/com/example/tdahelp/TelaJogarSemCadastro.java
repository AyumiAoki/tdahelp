package com.example.tdahelp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tdahelp.R;

public class TelaJogarSemCadastro extends AppCompatActivity {


    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogar_sem_cadastro);
        getSupportActionBar().hide();


        dialog = new AlertDialog.Builder(this);
    }

    public void prosseguir(View view) {

        final EditText campoNome = findViewById(R.id.editNomee);

        String nome = campoNome.getText().toString();


        if (!nome.equals("")) {
            campoNome.setText("");
            Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
            startActivity(intent);

        } else {
            dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Insira seu nome!");
            dialog.setPositiveButton("Ok", null);
            dialog.setCancelable(true);
            dialog.create();
            dialog.show();
        }
    }
}
