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
public class DueDateTest {
    List<String> request = new ArrayList<>();
    DueDate dueDate = new DueDate();
    GsonUtils gsonUtils = new GsonUtils();
    
    public DueDateTest() {
    }

    @Test
    public void testValid_OddParamsRequest() throws Exception {
        Config.init();
        
        request.add("DUE_DATE");
        request.add("Param2");
        
        String response = dueDate.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
    @Test
    public void testValid_NoDueDateBillRequest() throws Exception {
        Config.init();
        Config.lstBill = new ArrayList<>();
        
        request.add("DUE_DATE");
        
        String response = dueDate.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("15", respCode);
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
        
        request.add("DUE_DATE");
        
        String response = dueDate.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
}
