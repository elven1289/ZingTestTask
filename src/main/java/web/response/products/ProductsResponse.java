package web.response.products;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ProductsResponse {
    public ArrayList<Product> products;
    public int total;
    public int skip;
    public int limit;

    public static ProductsResponse parseJson(String json) {
        return new Gson().fromJson(json, ProductsResponse.class);
    }
}




