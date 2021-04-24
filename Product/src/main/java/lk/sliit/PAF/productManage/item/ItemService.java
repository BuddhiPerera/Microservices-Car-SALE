package lk.sliit.PAF.productManage.item;

import lk.sliit.PAF.productManage.model.ProductModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/item")
public class ItemService {


    ProductModel itemObj = new ProductModel();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String readItems()
    {
        return "Hello";
    }

}
