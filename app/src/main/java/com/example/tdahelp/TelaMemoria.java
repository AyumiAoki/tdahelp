package com.example.tdahelp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import static com.example.tdahelp.R.layout.activity_tela_memoria;

public class TelaMemoria extends AppCompatActivity {

    private static final Integer MAX_BOTOES = 6;

    private View btn[] = new View[MAX_BOTOES];

    private ProgressBar barra;
    private TextView textBarra;
    private int acertos;

    private TextView textoParabens;
    private TextView mensagemParabens;

    ArrayList<Integer> elementos;

    private MediaPlayer somCerto;
    private MediaPlayer somErro;
    private MediaPlayer somVitoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_tela_memoria);
        getSupportActionBar().hide();

        somCerto = MediaPlayer.create(getApplicationContext(), R.raw.som_certo);
        somErro = MediaPlayer.create(getApplicationContext(), R.raw.som_erro);
        somVitoria = MediaPlayer.create(getApplicationContext(), R.raw.som_vitoria);

        elementos = new ArrayList<>();
        acertos = 0;

        barra = findViewById(R.id.progresso);
        textBarra = findViewById(R.id.textProgresso);

        textoParabens = findViewById(R.id.textParabens);
        mensagemParabens = findViewById(R.id.textParabens2);

        btn[0] = findViewById(R.id.button_1);
        btn[1] = findViewById(R.id.button_2);
        btn[2] = findViewById(R.id.button_3);
        btn[3] = findViewById(R.id.button_4);
        btn[4] = findViewById(R.id.button_5);
        btn[5] = findViewById(R.id.button_6);

        reiniciar();

    }

    public void executarSom(View view, MediaPlayer som){
        if(som != null){
            som.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void alterar(View view) {

        if (view.getId() != btn[elementos.get(acertos)].getId()) {
            resetarBotoes();
            executarSom(view, somErro);
            //findViewById(R.id.tela_memoria).setBackgroundColor(Color.WHITE);
        } else {

            view.setVisibility(View.INVISIBLE);
            if(acertos < 5)
                executarSom(view, somCerto);

            try {
                //findViewById(R.id.tela_memoria).setBackgroundColor(view.getBackgroundTintList().getDefaultColor());
            }
            catch (NullPointerException e) {
                //findViewById(R.id.tela_memoria).setBackgroundColor(Color.WHITE);
            }
            acertos++;
            atualizarBarra(acertos);
        }
    }

    public void restart(View view){
        reiniciar();
    }

    public void resetarBotoes(){
        for(Integer i=0; i < MAX_BOTOES; i++) {
            btn[i].setVisibility(View.VISIBLE);
        }
        acertos = 0;
        atualizarBarra(acertos);
        //findViewById(R.id.tela_memoria).setBackgroundColor(new Color(r,g,b));
    }

    public void embaralhar() {

        elementos.clear();

        for (Integer i = 0; i < MAX_BOTOES; i++) {
            elementos.add(i);
            Collections.shuffle(elementos);
        }

        for (Integer i = 0; i < MAX_BOTOES; i++) {
            Log.i("ELEMENTOS", String.valueOf(elementos.get(i)));
        }
    }

    public void finalizou(){
        textBarra.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);
        textoParabens.setVisibility(View.VISIBLE);
        mensagemParabens.setVisibility(View.VISIBLE);
    }

    public void atualizarBarra(int acertos) {
        barra.setProgress(acertos);
        textBarra.setText(acertos + "/" + MAX_BOTOES);
        View view = null;

         if(acertos == MAX_BOTOES){
             executarSom(view, somVitoria);
             finalizou();
         }
    }

    public void reiniciar(){

        textBarra.setVisibility(View.VISIBLE);
        barra.setVisibility(View.VISIBLE);
        textoParabens.setVisibility(View.INVISIBLE);
        mensagemParabens.setVisibility(View.INVISIBLE);

        embaralhar();
        resetarBotoes();
    }

    @Override
    protected void onStop(){
        super.onStop();

        if(somVitoria.isPlaying() || somErro.isPlaying() || somCerto.isPlaying()){
            somCerto.pause();
            somErro.pause();
            somVitoria.pause();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        if((somVitoria.isPlaying() && somVitoria != null)  || (somErro.isPlaying() && somErro != null) || (somCerto.isPlaying() && somCerto != null)){
            somCerto.stop();
            somErro.stop();
            somVitoria.stop();

            somCerto.release();
            somErro.release();
            somVitoria.release();

            somCerto = null;
            somErro = null;
            somVitoria = null;

        }
    }
}
