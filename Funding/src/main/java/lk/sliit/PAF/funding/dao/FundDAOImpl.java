package lk.sliit.PAF.funding.dao;




import lk.sliit.PAF.funding.dto.FundDTO;

import java.util.ArrayList;
import java.util.List;

public class FundDAOImpl {
    private static FundDAOImpl instance;
    private static List<FundDTO> data = new ArrayList<>();

    static {

    }



    public static FundDAOImpl getInstance() {
        if (instance == null) {
            instance = new FundDAOImpl();
        }
        return instance;
    }

    public List<FundDTO> listAll() {
        return new ArrayList<>(data);
    }

    public int add(FundDTO product) {
        int newId = data.size() + 1;
        product.setId(newId);
        data.add(product);

        return newId;
    }

    public FundDTO get(int id) {
        FundDTO productToFind = new FundDTO(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            return data.get(index);
        }
        return null;
    }

    public boolean delete(int id) {
        FundDTO productToFind = new FundDTO(id);
        int index = data.indexOf(productToFind);
        if (index >= 0) {
            data.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(FundDTO product) {
        int index = data.indexOf(product);
        if (index >= 0) {
            data.set(index, product);
            return true;
        }
        return false;
    }
}