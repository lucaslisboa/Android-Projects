package br.com.cd.helloword;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Android on 18/06/2016.
 */
public class SegundaActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Chamar o XML (layout) que vai ser utilizado
        setContentView(R.layout.segunda_activity);

        //Vai resgatar a INTENT utilizada na primeira tela para essa
        Intent intent = getIntent();

        //Vai retornar o valor da intent "nome" criada na intent da primeira tela (MainActivity.java)
        String nome = intent.getStringExtra("nome");

        //Mensagem temporária mostrando o nome digitado na primeira página
        Toast.makeText(this, "Seja bem vindo " + nome, Toast.LENGTH_LONG).show();
    }
}

