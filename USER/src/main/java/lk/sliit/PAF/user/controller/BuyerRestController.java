package lk.sliit.PAF.user.controller;


import lk.sliit.PAF.user.dto.BuyerDTO;
import lk.sliit.PAF.user.model.BuyerModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/buyer")
public class BuyerRestController {

    BuyerModel buyerModel = BuyerModel.getInstance();

    BuyerModel buyerObject = new BuyerModel();

    //save
    @POST
    @Path("/saveUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addBuyer(BuyerDTO buyerDTO, @Context HttpServletRequest request) throws Exception {
        System.out.println(buyerDTO +"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        int s =buyerObject.insertBuyerDetail(
                buyerDTO.getfName(),
                buyerDTO.getlName(),
                buyerDTO.getEmail(),
                buyerDTO.getContactNo(),
                buyerDTO.getAddress(),
                buyerDTO.getZipCode(),
                buyerDTO.getPassword()
        );
        System.out.println(s);
        HttpSession session= request.getSession(true);session.setAttribute("buyerId", s);
        if (s != 0) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
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
