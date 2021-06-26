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
public class PaymentTest {
    List<String> request = new ArrayList<>();
    Payment payment = new Payment();
    GsonUtils gsonUtils = new GsonUtils();
    
    public PaymentTest() {
    }

    @Test
    public void testInvalid_LackParamsRequest() throws Exception {
        request.add("PAY");

        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("05", respCode);
    }
    
    @Test
    public void testInvalid_ValueParamsRequest() throws Exception {
        request.add("PAY");
        request.add("1Aa");
        
        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("06", respCode);
    }
    
    @Test
    public void testNotFound_BillIdParamsRequest() throws Exception {
        Config.init();
        
        request.add("PAY");
        request.add("10");
        
        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("07", respCode);
    }
    
    @Test
    public void testNotFound_MoreBillIdParamsRequest() throws Exception {
        Config.init();
        
        request.add("PAY");
        request.add("1");
        request.add("10");
        
        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("07", respCode);
    }
    
    @Test
    public void testInvalid_BalanceRequest() throws Exception {
        Config.init();
        
        List<String> topupRequest = new ArrayList<>();
        topupRequest.add("CASH_IN");
        topupRequest.add("1000000");
        Topup topup = new Topup();
        topup.doRequest(topupRequest);
        
        request.add("PAY");
        request.add("1");
        request.add("2");
        request.add("3");
        
        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("08", respCode);
    }
    
    @Test
    public void testValid_OneBillIdRequest() throws Exception {
        Config.init();
        
        List<String> topupRequest = new ArrayList<>();
        topupRequest.add("CASH_IN");
        topupRequest.add("1000000");
        Topup topup = new Topup();
        topup.doRequest(topupRequest);
        
        request.add("PAY");
        request.add("1");
        
        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
    @Test
    public void testValid_MoreBillIdRequest() throws Exception {
        Config.init();
        
        List<String> topupRequest = new ArrayList<>();
        topupRequest.add("CASH_IN");
        topupRequest.add("1000000");
        Topup topup = new Topup();
        topup.doRequest(topupRequest);
        
        request.add("PAY");
        request.add("2");
        request.add("3");
        
        String response = payment.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
}
