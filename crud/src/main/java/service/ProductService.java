package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements BaseCRUD<Product> {
    List<Product> products = new ArrayList<>();
    int currentId;
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void create(Product product) {
        product.setId(++currentId);
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for (Product item: products){
            if(item.getId() == product.getId()){
                item.setName(product.getName());
                item.setPrice(product.getPrice());
                item.setQuantity(product.getQuantity());
                item.setCategory(product.getCategory());
            }
        }
    }

    @Override
    public void delete(int id) {
        Product product = new Product();
        for (Product item: products){
            if (item.getId() == id){
                product = item;
            }
        }
        products.remove(product);
    }

    @Override
    public Product findById(int id) {
        for (Product item: products){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    public List<Product> searchProduct(String productName){
        List<Product> result = new ArrayList<>();
        products = findAll();
        for (Product product: products){
            if(product.getName().toUpperCase().contains(productName.toUpperCase())){
                result.add(product);
            }
        }
        return result;
    }
}
