package br.com.cd.androidstory;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.cd.androidstory.adapters.ProdutoAdapter;
import br.com.cd.androidstory.dominio.Produto;
import br.com.cd.androidstory.restclients.ProdutoRestClient;
import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lista_produtos)
    private ListView listView;
    private List<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lista_produtos);

        ProdutoAdapter adapter = new ProdutoAdapter(this, produtos);
        listView.setAdapter(adapter);

        new BuscarProdutosAsyncTask().execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, produtos.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class BuscarProdutosAsyncTask extends AsyncTask<Void, Void, List<Produto>>{


        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Buscando produtos...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected List<Produto> doInBackground(Void... params) {
            ProdutoRestClient restClient = new ProdutoRestClient();
            return restClient.list();
        }

        @Override
        protected void onPostExecute(List<Produto> prods) {
            super.onPostExecute(produtos);

            progressDialog.dismiss();

            produtos = prods;

            ProdutoAdapter adapter = (ProdutoAdapter) listView.getAdapter();
            adapter.setProdutos(produtos);
            adapter.notifyDataSetChanged();
        }


    }
}
