package lk.sliit.PAF.user.controller;


import lk.sliit.PAF.user.dao.BuyerDAOImpl;
import lk.sliit.PAF.user.dto.BuyerDTO;
import lk.sliit.PAF.user.model.BuyerModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/buyer")
public class BuyerRestController {
    BuyerDAOImpl buyerDAO = BuyerDAOImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BuyerDTO> buyerDTOList(){
        return buyerDAO.listAll();
    }

    BuyerModel buyerModel = new BuyerModel();
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void insertUser(@FormParam("fName") String fName,
                           @FormParam("lName") String lName,
                           @FormParam("email") String email,
                           @FormParam("contactNo") String contactNo,
                           @FormParam("address") String address,
                           @FormParam("zipCode") String zipCode,
                           @FormParam("pass") String pass) {
        String output = buyerModel.insertBuyerDetail(fName, lName, email, contactNo, address, zipCode, pass);

    }

}
