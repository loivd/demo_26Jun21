/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.business;

import com.google.gson.JsonObject;
import demomomo.app.config.Config;
import demomomo.app.utils.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mrloi
 */
public class ListPaymentTest {
    List<String> request = new ArrayList<>();
    ListPayment listPayment = new ListPayment();
    GsonUtils gsonUtils = new GsonUtils();
    
    public ListPaymentTest() {
    }

    @Test
    public void testValid_OddParamsRequest() throws Exception {
        Config.init();
        
        request.add("LIST_PAYMENT");
        request.add("Param2");
        
        String response = listPayment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
    @Test
    public void testValid_Request() throws Exception {
        Config.init();
        
        List<String> topupRequest = new ArrayList<>();
        topupRequest.add("CASH_IN");
        topupRequest.add("1000000");
        Topup topup = new Topup();
        topup.doRequest(topupRequest);
        
        List<String> paymentRequest = new ArrayList<>();
        paymentRequest.add("PAY");
        paymentRequest.add("1");
        Payment payment = new Payment();
        payment.doRequest(paymentRequest);
        
        request.add("LIST_PAYMENT");
        
        String response = listPayment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
}
