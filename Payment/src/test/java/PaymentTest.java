import lk.sliit.PAF.payment.controller.PaymentController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;

public class PaymentTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(PaymentController.class);
    }
/*    @Test
    public void ordersPathParamTest() {
        String response = target("payment/getProducts").request().get(String.class);
        Assert.assertTrue("orderId: 453".equals(response));
    }*/

    @Test
    public void ordersFixedPathTest() {
        String response = target("payment/getProducts").request().get(String.class);
        Assert.assertTrue("payment getProducts".equals(response));
    }
}
