package lk.sliit.PAF.user.controller;


import lk.sliit.PAF.user.dto.BuyerDTO;
import lk.sliit.PAF.user.model.BuyerModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/buyer")
public class BuyerRestController {

    BuyerModel buyerModel = BuyerModel.getInstance();

    BuyerModel buyerObject = new BuyerModel();

    //save
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void addBuyer(BuyerDTO buyerDTO){
        buyerObject.insertBuyerDetail(
                buyerDTO.getfName(),
                buyerDTO.getlName(),
                buyerDTO.getEmail(),
                buyerDTO.getContactNo(),
                buyerDTO.getAddress(),
                buyerDTO.getZipCode(),
                buyerDTO.getPassword()
        );
    }

    //update
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void updateBuyer(BuyerDTO buyerDTO){
        buyerObject.updateBuyerDetail(
                buyerDTO.getfName(),
                buyerDTO.getlName(),
                buyerDTO.getEmail(),
                buyerDTO.getContactNo(),
                buyerDTO.getAddress(),
                buyerDTO.getZipCode()
        );
    }

    //delete
    @DELETE
    @Path("/delete/{id}")
    public Response deleteBuyer(@PathParam("id") int id){
        if(buyerModel.deleteBuyer(id)){
            return Response.ok().build();
        }
        else{
            return Response.notModified().build();
        }
    }

}
