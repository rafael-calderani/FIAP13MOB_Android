package com.sample.rm39951.aula02;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout txtNome;
    private TextInputLayout txtIdade;
    private Spinner spnTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (TextInputLayout) findViewById(R.id.tilNome);
        txtIdade = (TextInputLayout) findViewById(R.id.tilIdade);
        spnTimes = (Spinner) findViewById(R.id.spnTimes);
    }

    public void cadastrar(View v) {
        String nome = txtNome.getEditText().getText().toString();
        String idade = txtIdade.getEditText().getText().toString();
        String timeSelecionado = spnTimes.getSelectedItem().toString();
        Boolean camposValidos = ValidarCampos();
        if (!camposValidos) return;

        Intent iConfirmar = new Intent(this, ConfirmacaoActivity.class);

        iConfirmar.putExtra("NOME", nome);
        iConfirmar.putExtra("IDADE", idade);
        iConfirmar.putExtra("TIME", timeSelecionado);

        startActivity(iConfirmar);
        txtNome.getEditText().setText("");
        txtIdade.getEditText().setText("");
        spnTimes.setSelection(0);
    }

    private boolean ValidarCampos() {
        String msg = "";
        int toastDuration = Toast.LENGTH_SHORT;

        if (txtNome.getEditText().getText().toString().isEmpty()) {
            msg += "Favor digitar seu nome.\n";
        }
        if (txtIdade.getEditText().getText().toString().isEmpty()) {
            msg += "Favor digitar sua idade.\n";
        }
        if (spnTimes.getSelectedItemPosition() == 0)
            msg += "Favor selecionar seu time.";

        if (!msg.isEmpty()) {
            if (msg.length()>50) toastDuration = Toast.LENGTH_LONG;

            Toast.makeText(getApplicationContext(), msg, toastDuration).show();
        }
        return msg.isEmpty();
    }
}
