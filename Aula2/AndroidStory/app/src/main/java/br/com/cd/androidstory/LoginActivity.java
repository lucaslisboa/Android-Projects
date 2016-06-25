package br.com.cd.androidstory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername;
    private EditText edtPassword;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText) findViewById(R.id.textUser);
        edtPassword = (EditText) findViewById(R.id.textPassword);

        //Caixa de diálogo de espera
        pDialog = new ProgressDialog(this);
        pDialog.setTitle("Aguarde...");
        pDialog.setMessage("Processando...");
        pDialog.setCancelable(false);
    }

    public void login(View view) {
        String username = this.edtUsername.getText().toString();
        String password = this.edtPassword.getText().toString();
        Boolean error = false;

        //Validar campos obrigatórios
        if (username.isEmpty()) {
            this.edtUsername.setError(getString(R.string.required_field));
            error = true;
        }

        if (password.isEmpty()) {
            this.edtPassword.setError(getString(R.string.required_field));
            error = true;
        }

        if (!error) {
            //Iniciar a janela de espera
            pDialog.show();

            //Chamar Thread
            Login login = new Login();
            Thread thread = new Thread(login);
            thread.start();
        }
    }

    //Criação da classe com a thread
    class Login implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);

                //Fecha a tela de espera
                pDialog.dismiss();

                //Chama a próxima Activity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
