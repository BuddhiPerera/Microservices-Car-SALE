package lk.sliit.PAF.productManage.item;

import lk.sliit.PAF.productManage.model.ProductModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/item")
public class ItemService {


    ProductModel itemObj = new ProductModel();
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String insertItem(@FormParam("itemCode") String itemCode,
                             @FormParam("itemName") String itemName,
                             @FormParam("itemPrice") String itemPrice,
                             @FormParam("itemDesc") String itemDesc)
    {
        String output = itemObj.insertItem(itemCode, itemName, itemPrice, itemDesc);
        System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddd");
        return output;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String readItems()
    {
        return "Hello";
    }

}
