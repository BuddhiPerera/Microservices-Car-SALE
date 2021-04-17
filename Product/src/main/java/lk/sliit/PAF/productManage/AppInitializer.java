package lk.sliit.PAF.productManage;


import lk.sliit.PAF.productManage.controller.Product;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AppInitializer {
    private static String host = "http://localhost/Product_war/rest/products/";
    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(host);
        String resp = target.request().accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(resp);
        testGet();
        testUpdate();
        testAdd();
        testGet();
        testDelete();testList();

    }
    static WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);

        return client.target(host);
    }
    static void testList() {
        WebTarget target = getWebTarget();

        String response = target.request().accept(MediaType.APPLICATION_JSON).get(String.class);

        System.out.println(response);
    }
    static void testGet() {
        WebTarget target = getWebTarget();
        String productId = "1";
        Product product = target.path(productId)
                .request().accept(MediaType.APPLICATION_JSON)
                .get(Product.class);

        System.out.println(product);
    }
    static void testAdd() {
        WebTarget target = getWebTarget();
        Product product = new Product("ZenFoneX", 888.88f);
        Response response = target.request()
                .post(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);

        System.out.println(response.getLocation().toString());
    }
    private static void testUpdate() {
        WebTarget target = getWebTarget();
        Product product = new Product("ZenFoneX", 100f);
        String productId = "1";
        Response response = target.path(productId).request()
                .put(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);
        System.out.println(response);
    }
    private static void testDelete() {
        WebTarget target = getWebTarget();
        String productId = "1";
        Response response = target.path(productId).request()
                .delete(Response.class);
        System.out.println(response);
    }
}
