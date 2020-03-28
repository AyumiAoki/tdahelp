package com.example.tdahelp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TelaCadastro extends AppCompatActivity {

    private DatabaseReference referencia;
    private DatabaseReference usuarios;
    private Usuario usuario;
    private FirebaseAuth usuariosAuth;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        getSupportActionBar().hide();

        referencia = FirebaseDatabase.getInstance().getReference();
        usuarios = referencia.child("usuarios");
        usuario = new Usuario();
        usuariosAuth = FirebaseAuth.getInstance();
        dialog = new AlertDialog.Builder(this);

        /*
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

    public void cadastrarUsuario(View view){

        EditText campoNome = findViewById(R.id.editNome);
        EditText campoEmail = findViewById(R.id.editEmail);
        EditText campoSenha = findViewById(R.id.editSenha);
        EditText campoConfSenha = findViewById(R.id.editConfSenha);

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        String senha = campoSenha.getText().toString();
        String confSenha = campoConfSenha.getText().toString();

        usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        if(senha.length() >= 6){

            if(senha.equals(confSenha)){

                usuarios.child("1").setValue(usuario);

                usuariosAuth = FirebaseAuth.getInstance();
                usuariosAuth.createUserWithEmailAndPassword(email, senha)
                        .addOnCompleteListener(TelaCadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Log.i("createUser", "sucesso");
                                    dialog.setMessage("Usuário cadastrado com sucesso!");
                                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                                    dialog.setIcon(R.drawable.ic_check_black_24dp);
                                    dialog.setCancelable(false);
                                    dialog.create();
                                    dialog.show();


                                } else{
                                    Log.i("createUser", "erro");
                                    dialog.setMessage("Erro ao cadastrar usuário!");
                                    dialog.setPositiveButton("Ok", null);
                                    dialog.setIcon(R.drawable.ic_close_black_24dp);
                                    dialog.setCancelable(false);
                                    dialog.create();
                                    dialog.show();
                                }
                            }
                        });
            } else {
                Log.i("createUser", "senha incorreta");
                dialog.setMessage("As senhas não coincidem!");
                dialog.setPositiveButton("Ok", null);
                dialog.setIcon(R.drawable.ic_close_black_24dp);
                dialog.setCancelable(true);
                dialog.create();
                dialog.show();
            }

        } else {
            Log.i("createUser", "senha incorreta");
            dialog.setMessage("A senha deve ter pelo menos seis caracteres!");
            dialog.setPositiveButton("Ok", null);
            dialog.setIcon(R.drawable.ic_error_black_24dp);
            dialog.setCancelable(true);
            dialog.create();
            dialog.show();
        }
    }

    public void entrar(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
