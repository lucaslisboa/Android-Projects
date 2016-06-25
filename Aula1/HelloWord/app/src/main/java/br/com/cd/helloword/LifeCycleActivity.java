package br.com.cd.helloword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ASUS on 25/06/2016.
 */
public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifeCycle","Abriu onCreate");
        Toast.makeText(this, "Abriu onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","Abriu onStart");
        Toast.makeText(this, "Abiu onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","Abriu onResume");
        Toast.makeText(this, "Abriu onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","Abriu onPause");
        Toast.makeText(this, "Abriu onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","Abriu onRestart");
        Toast.makeText(this, "Abriu onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","Abriu onStop");
        Toast.makeText(this, "Abriu onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","Abriu onDestroy");
        Toast.makeText(this, "Abriu onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        EditText editEmail = (EditText) findViewById(R.id.email);
        editEmail.setError(getString(R.string.email_incorrect_message));
    }
}
