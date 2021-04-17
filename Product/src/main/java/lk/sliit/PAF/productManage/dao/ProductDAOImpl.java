package lk.sliit.PAF.productManage.dao;


import lk.sliit.PAF.productManage.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl {
    private static ProductDAOImpl instance;
    private static List<ProductDTO> data = new ArrayList<>();

    static {
        data.add(new ProductDTO(1, "iPhone X", 999.99f));
        data.add(new ProductDTO(2, "XBOX 360", 329.50f));
    }



    public static ProductDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProductDAOImpl();
        }
        return instance;
    }

    public List<ProductDTO> listAll() {
        return new ArrayList<>(data);
    }

    public int add(ProductDTO product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);

        return newId;
    }

    public ProductDTO get(int id) {
        ProductDTO productToFind = new ProductDTO(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }

    public boolean delete(int id) {
        ProductDTO productToFind = new ProductDTO(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(ProductDTO product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }
}