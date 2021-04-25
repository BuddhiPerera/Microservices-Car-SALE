package lk.sliit.PAF.payment.controller;

import lk.sliit.PAF.payment.dto.PlaceOrderDTO;
import lk.sliit.PAF.payment.dto.ProDTO;
import lk.sliit.PAF.payment.dto.SetOrderDTO;
import lk.sliit.PAF.payment.model.ProductModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payment")
public class PaymentController {

    ProductModel dao2 = ProductModel.getInstance();

    @GET
    @Path("/getProducts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SetOrderDTO> list(@PathParam("id") String url, @Context HttpServletRequest req) throws Exception {

        HttpSession session = req.getSession(true);
        session.setAttribute("buyerId", url);

        return dao2.listAll(url);
    }


    @GET
    @Path("setProduct/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setProduct(@PathParam("id") int id, @Context HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("itemId", id);

        if (id != 0) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }

    @GET
    @Path("/getProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public ProDTO getProduct(@Context HttpServletRequest request) throws Exception {
        HttpSession httpSession = request.getSession(true);
        Object userId = httpSession.getAttribute("itemId");
        if (userId != null) {
            System.out.println(userId.toString());
        } else {
            httpSession.setAttribute("itemId", "");
        }

        String item = (httpSession.getAttribute("itemId").toString());

        return dao2.findOne(item);
    }

    @POST
    @Path("/saveOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void placeOrder(PlaceOrderDTO placeOrderDTO, @Context HttpServletRequest request) {
        HttpSession httpSession1 = request.getSession(true);
        Object userId2 = httpSession1.getAttribute("buyerId");
        if (userId2 != null) {
            System.out.println(userId2.toString());
        } else {
            httpSession1.setAttribute("buyerId", "");
        }
        String buyerId = (httpSession1.getAttribute("buyerId").toString());


        HttpSession httpSession = request.getSession(true);
        Object userId = httpSession.getAttribute("itemId");
        if (userId != null) {
            System.out.println(userId.toString());
        } else {
            httpSession.setAttribute("itemId", "");
        }

        String item = (httpSession.getAttribute("itemId").toString());
//////////////////////////////////////////////////////////////////////////

        System.out.println(buyerId + " " + item);
        dao2.placeOrder(item, buyerId, placeOrderDTO.getName(), placeOrderDTO.getAddress(), placeOrderDTO.getState(), placeOrderDTO.getCountry()
                , placeOrderDTO.getZip(), placeOrderDTO.getContact(), placeOrderDTO.getQty());

    }

}

