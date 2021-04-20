package lk.sliit.PAF.productManage.controller;

import com.mysql.cj.xdevapi.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import lk.sliit.PAF.productManage.dto.ProDTO;
import lk.sliit.PAF.productManage.dto.ProductDTO;
import lk.sliit.PAF.productManage.model.ProductModel;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpStatus;
import org.cloudinary.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.w3c.dom.Document;

@Path("/products")
public class ProductRestController {

    ProductModel dao2 = ProductModel.getInstance();


    @GET
    @Path("/getProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProDTO> list() throws Exception {
        System.out.println(dao2.listAll());
        return dao2.listAll();
    }


    ProductModel itemObj = new ProductModel();

/*   @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void insertItem(@FormParam("name") String name,
                           @FormParam("description") String description,
                           @FormParam("price") String price,
                           @FormParam("qty") String qty,
                           @FormParam("shipping") String shipping,
                           @FormParam("image") String image) {
        String output = itemObj.insertItem(name, description, price, qty, shipping, image);

    }*/
    @POST
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    public void doGet(HttpServletRequest request) throws ServletException, IOException {

        String userName = request.getParameter("id").trim();
        System.out.println(userName+"ssssssssssssssssssssssssssssssssssssssssssssss");
 /*       if(userName == null || "".equals(userName)){
            userName = "Guest";
        }*/
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");


    }



    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateItem(String itemData) {

        String itemID = null, itemCode = null, itemName = null, itemPrice = null, itemDesc = null;

            JSONObject object = new JSONObject();
            itemID = (object.getString("id"));
            itemCode = (object.getString("Name"));
            itemName = (object.getString("Name"));
            itemPrice = (object.getString("Name"));
            itemDesc = (object.getString("Name"));

//Read the values from the JSON object

        String output = itemObj.updateItem(itemID, itemCode, itemName, itemPrice, itemDesc);
        return output;
    }



/*
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        //ProductDTO product = dao.get(id);
        if (product != null) {
            return Response.ok(product, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }*/

/*
    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        if (dao2.deleteItem(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
*/

 /*   @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, ProductDTO product) {
        product.setId(id);
        if (dao.update(product)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }*/
}
