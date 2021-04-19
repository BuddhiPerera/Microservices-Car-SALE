package lk.sliit.PAF.user.controller;

import lk.sliit.PAF.user.dao.BuyerDAOImpl;
import lk.sliit.PAF.user.dto.BuyerDTO;
import lk.sliit.PAF.user.model.BuyerModel;

import javax.ws.rs.*;

import java.util.List;

/*@Path("/buyers")*/
public class BuyerRestController {
/*    BuyerDAOImpl buyerDAO = BuyerDAOImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BuyerDTO> buyerDTOList(){
        return buyerDAO.listAll();
    }

    BuyerModel buyerModel = new BuyerModel();
    @POST
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    public void insertUser(@FormParam("fName") String fName,
                           @FormParam("lName") String lName,
                           @FormParam("email") String email,
                           @FormParam("contact") String contact,
                           @FormParam("address") String address,
                           @FormParam("zipcode") String zipcode,
                           @FormParam("pass") String pass) {

        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        String output = buyerModel.insertBuyerDetail(fName, lName, email, contact, address, zipcode, pass);

    }*/

}
