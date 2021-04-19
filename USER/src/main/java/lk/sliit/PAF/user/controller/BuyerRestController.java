package lk.sliit.PAF.user.controller;

import lk.sliit.PAF.user.dao.BuyerDAOImpl;
import lk.sliit.PAF.user.dto.BuyerDTO;

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

}
