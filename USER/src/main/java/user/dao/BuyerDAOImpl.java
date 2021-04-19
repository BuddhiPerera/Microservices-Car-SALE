package user.dao;


import user.dto.BuyerDTO;

import java.util.ArrayList;
import java.util.List;

public class BuyerDAOImpl {
    private static BuyerDAOImpl buyerDAO;
    private static List<BuyerDTO> buyerDTOList = new ArrayList<>();


    public static BuyerDAOImpl getInstance() {
        if (buyerDAO == null) {
            buyerDAO = new BuyerDAOImpl();
        }
        return buyerDAO;
    }

    public int add(BuyerDTO buyerDTO) {
        int newId = buyerDTOList.size() + 1;
        buyerDTO.setId(newId);
        buyerDTOList.add(buyerDTO);

        return newId;
    }

    public BuyerDTO get(int id) {
        BuyerDTO findBuyer = new BuyerDTO(id);
        int index = buyerDTOList.indexOf(findBuyer);
        if (index >= 0) {
            return buyerDTOList.get(index);
        }
        return null;
    }

    public boolean delete(int id) {
        BuyerDTO findBuyer = new BuyerDTO(id);
        int index = buyerDTOList.indexOf(findBuyer);
        if (index >= 0) {
            buyerDTOList.remove(index);
            return true;
        }

        return false;
    }

    public boolean update(BuyerDTO product) {
        int index = buyerDTOList.indexOf(product);
        if (index >= 0) {
            buyerDTOList.set(index, product);
            return true;
        }
        return false;
    }

    public List<BuyerDTO> listAll() {
        return new ArrayList<>(buyerDTOList);
    }
}
