package com.example.appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_altura, edit_peso, edit_resultado;
    private Button btn_calcular, btn_limpar, btn_sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_peso = (EditText) findViewById(R.id.edit_peso);
        edit_altura = (EditText) findViewById(R.id.edit_altura);
        edit_resultado = (EditText) findViewById(R.id.edit_resultado);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_limpar = (Button) findViewById(R.id.btn_limpar);
        btn_sair = (Button) findViewById(R.id.btn_sair);


        btn_calcular.setOnClickListener(this);
        btn_limpar.setOnClickListener(this);
        btn_sair.setOnClickListener(this);

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_calcular) {// botão Calcular

            String mensagem = "";

            try {
                // obter os valores digitados convertidos
                double peso = Double.parseDouble(edit_peso.getText().toString());
                double altura = Double.parseDouble(edit_altura.getText().toString());
                // calcular o resultado
                double resultado = peso / Math.pow(altura, 2); //altura ao quadrado
                // Mostrar o resultado formatado com 2 casas decimais
                edit_resultado.setText(String.format("%.2f", resultado));

                if (resultado < 18)
                    mensagem = "Abaixo do peso";
                else if (resultado <= 24.9)
                    mensagem = "Peso normal";
                else if (resultado <= 29.9)
                    mensagem = "Excesso de peso";
                else if (resultado >= 30)
                    mensagem = "Sobrepeso";
                else
                    mensagem = "não calculado";
            } catch (Exception e) {
                mensagem = "Valores invalidos";
            }

        }
        else if (view.getId() == R.id.btn_limpar) {

            String msg = "Os dados foram apagados";

            edit_peso.setText("");
            edit_altura.setText("");
            edit_resultado.setText("");

            edit_peso.requestFocus();

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.btn_sair)
        {
            //System.exit(0);
            finish();
        }
    }
}