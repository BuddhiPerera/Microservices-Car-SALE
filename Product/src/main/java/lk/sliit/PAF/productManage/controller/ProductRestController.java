package lk.sliit.PAF.productManage.controller;


import lk.sliit.PAF.productManage.dao.ProductDAOImpl;
import lk.sliit.PAF.productManage.dto.ProductDTO;
import lk.sliit.PAF.productManage.model.ProductModel;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/products")
public class ProductRestController {
     ProductDAOImpl dao = ProductDAOImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> list() {
        return dao.listAll();
    }

    ProductModel itemObj = new ProductModel();
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String insertItem(@FormParam("itemCode") String itemCode,
                             @FormParam("itemName") String itemName,
                             @FormParam("itemPrice") String itemPrice,
                             @FormParam("itemDesc") String itemDesc) {
        String output = itemObj.insertItem(itemCode, itemName, itemPrice, itemDesc);
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
        ProductDTO product = dao.get(id);
        if (product != null) {
            return Response.ok(product, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (dao.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, ProductDTO product) {
        product.setId(id);
        if (dao.update(product)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}
