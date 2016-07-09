package br.com.cd.androidstory.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.cd.androidstory.R;
import br.com.cd.androidstory.dominio.Produto;

/**
 * Created by ASUS on 09/07/2016.
 */
public class ProdutoAdapter extends BaseAdapter{

    private List<Produto> produtos;
    private Context context;

    public ProdutoAdapter(Context context,List<Produto> produtos){
             this.produtos = produtos;
             this.context = context;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Produto getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if(convertView == null){
            //permite transformar o xml em objeto java
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_produto, null);
        }

        Produto produto = getItem(position);
        TextView nomeProduto = (TextView) convertView.findViewById(R.id.nome_produto);
        TextView codigoProduto = (TextView) convertView.findViewById(R.id.codigo_produto);
        TextView precoProduto = (TextView) convertView.findViewById(R.id.preco_produto);
        ImageView imagem = (ImageView) convertView.findViewById(R.id.imagem);

        nomeProduto.setText(produto.getName());
        codigoProduto.setText(produto.getId().toString());

        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

        precoProduto.setText(format.format(produto.getPrice()));

        return convertView;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
