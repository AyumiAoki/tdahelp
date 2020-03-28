package com.example.tdahelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia;
    private FirebaseAuth usuariosAuth;
    private Usuario usuario;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        referencia = FirebaseDatabase.getInstance().getReference();
        usuariosAuth = FirebaseAuth.getInstance();
        usuario = new Usuario();
        dialog = new AlertDialog.Builder(this);
    }

    public void cadastre_se(View view){
        Intent intent = new Intent(getApplicationContext(), TelaCadastro.class);
        startActivity(intent);
    }

    public void logar(View view){

        final EditText campoEmail = findViewById(R.id.nomeEdit);
        final EditText campoSenha = findViewById(R.id.senhaEdit);

        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();

        usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);

//        if(!email.equals("") && !senha.equals("")){
//            usuariosAuth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
//                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                campoEmail.setText("");
//                                campoSenha.setText("");
//                                Log.i("createUser", "usuario logado");
                                Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
                                startActivity(intent);
//                            } else{
//                                dialog.setMessage("Email ou senha incorretos!");
//                                dialog.setPositiveButton("Ok", null);
//                                dialog.setCancelable(true);
//                                dialog.create();
//                                dialog.show();
//
//                                Log.i("createUser", "usuario erro");
//                            }
//                        }
//                    });
//        } else {
//            dialog = new AlertDialog.Builder(this);
//            dialog.setMessage("Preencha todos os campos!");
//            dialog.setPositiveButton("Ok", null);
//            dialog.setCancelable(true);
//            dialog.create();
//            dialog.show();
//        }

    }
}
