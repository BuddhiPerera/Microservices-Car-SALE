package lk.sliit.PAF.funding.controller;


import lk.sliit.PAF.funding.dao.FundDAOImpl;
import lk.sliit.PAF.funding.dto.FundDTO;
import lk.sliit.PAF.funding.model.FundModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/funds")
public class FundingController {
    FundDAOImpl dao = FundDAOImpl.getInstance();
    FundModel model = new FundModel();


    @GET
    @Path("/getfunds")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FundDTO> list() throws Exception {
        return model.listAll();
    }

    FundModel fundObj = new FundModel();

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/save")
    public String insertFund(
            @FormParam("id") String id,
            @FormParam("fundName") String fundName,
            @FormParam("email") String email,
            @FormParam("address") String address,
            @FormParam("contactNumber") String contactNumber,
            @FormParam("amount") String amount,
            @FormParam("fundMethod") String fundMethod) {
        String output = fundObj.insertFund(id, fundName, email, address, contactNumber, fundMethod, amount);
        System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddd");
        return output;
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void updateProduct(FundDTO fundDTO) {
        System.out.println(fundDTO);
        fundObj.updateFund(fundDTO.getId(),fundDTO.getFundID(), fundDTO.getFundName(),fundDTO.getEmail(),fundDTO.getAddress(),fundDTO.getContactNumber(),fundDTO.getFundMethod(),fundDTO.getAmount());

    }


    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") String id) {

        System.out.println("dddddddddddddddddddddrrrrrrrrrrrrddddddddddddddd " + id);
        model.deleteFund(id);
    }

}