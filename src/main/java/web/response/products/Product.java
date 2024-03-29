package web.response.products;

import java.util.ArrayList;

/**
 * POJO class for auth/products API
 */
public class Product{
    public int id;
    public String title;
    public String description;
    public int price;
    public double discountPercentage;
    public double rating;
    public int stock;
    public String brand;
    public String category;
    public String thumbnail;
    public ArrayList<String> images;
}