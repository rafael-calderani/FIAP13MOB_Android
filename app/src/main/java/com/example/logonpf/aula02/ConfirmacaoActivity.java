package com.example.logonpf.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmacaoActivity extends AppCompatActivity {
    private TextView lblConfirmacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        lblConfirmacao = (TextView) findViewById(R.id.lblConfirmacao);

        if(getIntent() != null) {
            String nome = getIntent().getStringExtra("NOME");
            String idade = getIntent().getStringExtra("IDADE");
            String time =getIntent().getStringExtra("TIME");

            lblConfirmacao.setText(getString(R.string.respostaPadrao, nome, idade, time));
        }

    }

    public void voltarMain(View view) {
        if(getIntent() != null) {
        }
    }
}
