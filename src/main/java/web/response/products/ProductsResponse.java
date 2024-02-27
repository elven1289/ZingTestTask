package web.response.products;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * POJO class for auth/products API
 */
public class ProductsResponse {
    public ArrayList<Product> products;
    public int total;
    public int skip;
    public int limit;

    /**
     * Function that is used to parse json string into an instance of ProductsResponse
     * @param json - string to be parsed
     * @return parsed instance of ProductsResponse
     */
    public static ProductsResponse parseJson(String json) {
        return new Gson().fromJson(json, ProductsResponse.class);
    }
}




