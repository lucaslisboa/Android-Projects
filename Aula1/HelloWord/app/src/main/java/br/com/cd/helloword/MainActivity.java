package br.com.cd.helloword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Transformar o "EditText" que está na View XML para formato JAVA
        editText = (EditText) findViewById(R.id.editText);

    }

    public void mostrarSegundaTela(View view) {

        //Chamar a intenção de abrir uma nova tela, nesse caso SegundaActivity
        Intent intent = new Intent(this, SegundaActivity.class);

        //Jogar o valor da primeira tela para segunda tela
        String nome = editText.getText().toString();
        intent.putExtra("nome",nome);

        //Startar a Activity para chamar a nova tela
        startActivity(intent);
    }
}
