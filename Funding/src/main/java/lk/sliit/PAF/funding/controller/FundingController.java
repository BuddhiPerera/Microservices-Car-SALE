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
    public String insertFund(
                             @FormParam("id") String id,
                             @FormParam("fundName") String fundName,
                             @FormParam("email") String email,
                             @FormParam("address") String address,
                             @FormParam("contactNumber") String contactNumber,
                             @FormParam("amount") String amount,
                             @FormParam("fundMethod") String fundMethod) {
        String output = fundObj.insertFund(id,fundName, email, address, contactNumber,fundMethod,amount);
        System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddd");
        return output;
    }

  /*  @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Product product) throws URISyntaxException {

        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssss");
        int newProductId = dao.add(product);
        URI uri = new URI("/products/" + newProductId);
        return Response.created(uri).build();
    }
*/




    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        FundDTO Fund = dao.get(id);
        if (Fund != null) {
            return Response.ok(Fund, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") String id) {
        if (model.deleteFund(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, FundDTO Fund) {
        Fund.setId(id);
        if (dao.update(Fund)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}
