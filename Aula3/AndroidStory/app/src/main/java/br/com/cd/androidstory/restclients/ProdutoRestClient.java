package br.com.cd.androidstory.restclients;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.cd.androidstory.dominio.Produto;

/**
 * Created by ASUS on 09/07/2016.
 */
public class ProdutoRestClient extends RestClient {

    public List<Produto> list(){
        String jsonString = doGet("http://cdstoreapi.herokuapp.com/produtos.json");
        List<Produto> produtos = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);

                Produto produto = new Produto();
                produto.setId(object.getLong("id"));
                produto.setName(object.getString("name"));
                produto.setDescription(object.getString("description"));
                produto.setPrice(object.getDouble("price"));

                produtos.add(produto);
            }

            return produtos;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

}
