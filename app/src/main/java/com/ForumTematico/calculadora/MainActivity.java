package com.ForumTematico.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtracao, multiplicacao, divisao, igual, limpar;


    private TextView texto_entrada, texto_resultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponent();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto_entrada.setText("");
                texto_resultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView resultado = findViewById(R.id.texto_entrada);
                String string = resultado.getText().toString();

                if (!string.isEmpty()) {
                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String textoResultado = string.substring(var0, var1);
                    resultado.setText(textoResultado);
                }

                texto_resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expression = new ExpressionBuilder(texto_entrada.getText().toString()).build();
                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {

                        texto_resultado.setText((CharSequence) String.valueOf(longResult));
                    } else texto_resultado.setText((CharSequence) String.valueOf(resultado));
                } catch (Exception e) {

                }
            }
        });


    }


    private void IniciarComponent() {
        numeroZero = findViewById(R.id.button_numero_0);
        numeroUm = findViewById(R.id.button_numero_1);
        numeroDois = findViewById(R.id.button_numero_2);
        numeroTres = findViewById(R.id.button_numero_3);
        numeroQuatro = findViewById(R.id.button_numero_4);
        numeroCinco = findViewById(R.id.button_numero_5);
        numeroSeis = findViewById(R.id.button_numero_6);
        numeroSete = findViewById(R.id.button_numero_7);
        numeroOito = findViewById(R.id.button_numero_8);
        numeroNove = findViewById(R.id.button_numero_9);
        ponto = findViewById(R.id.button_numero_ponto);
        soma = findViewById(R.id.button_numero_somar);
        subtracao = findViewById(R.id.button_numero_subtrair);
        multiplicacao = findViewById(R.id.button_numero_x);
        divisao = findViewById(R.id.button_dividir);
        igual = findViewById(R.id.button_numero_igual);
        limpar = findViewById(R.id.button_limpar);
        texto_entrada = findViewById(R.id.texto_entrada);
        texto_resultado = findViewById(R.id.texto_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        if (texto_resultado.getText().equals("")) {
            texto_entrada.setText(" ");
        }
        if (limpar_dados) {
            texto_resultado.setText(" ");
            texto_entrada.append(string);
        } else {
            texto_entrada.append(texto_resultado.getText());
            texto_entrada.append(string);
            texto_resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_numero_0:
                AcrescentarUmaExpressao("0", true);
                break;

            case R.id.button_numero_1:
                AcrescentarUmaExpressao("1", true);
                break;
            case R.id.button_numero_2:
                AcrescentarUmaExpressao("2", true);
                break;
            case R.id.button_numero_3:
                AcrescentarUmaExpressao("3", true);
                break;
            case R.id.button_numero_4:
                AcrescentarUmaExpressao("4", true);
                break;
            case R.id.button_numero_5:
                AcrescentarUmaExpressao("5", true);
                break;
            case R.id.button_numero_6:
                AcrescentarUmaExpressao("6", true);
                break;
            case R.id.button_numero_7:
                AcrescentarUmaExpressao("7", true);
                break;
            case R.id.button_numero_8:
                AcrescentarUmaExpressao("8", true);
                break;
            case R.id.button_numero_9:
                AcrescentarUmaExpressao("9", true);
                break;
            case R.id.button_numero_ponto:
                AcrescentarUmaExpressao(".", true);
                break;
            case R.id.button_numero_somar:
                AcrescentarUmaExpressao("+", false);
                break;
            case R.id.button_numero_subtrair:
                AcrescentarUmaExpressao("-", false);
                break;
            case R.id.button_numero_x:
                AcrescentarUmaExpressao("*", false);
                break;
            case R.id.button_dividir:
                AcrescentarUmaExpressao("/", false);
                break;


        }
    }
}