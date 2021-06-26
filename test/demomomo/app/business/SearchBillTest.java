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
public class SearchBillTest {
    List<String> request = new ArrayList<>();
    SearchBill searchBill = new SearchBill();
    GsonUtils gsonUtils = new GsonUtils();
    
    public SearchBillTest() {
    }

    @Test
    public void testInvalid_LackParamsRequest() throws Exception {
        request.add("SEARCH_BILL_BY_PROVIDER");

        String response = searchBill.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("13", respCode);
    }
    
    @Test
    public void testInvalid_OddParamsRequest() throws Exception {
        request.add("SEARCH_BILL_BY_PROVIDER");
        request.add("Param2");
        request.add("Param3");

        String response = searchBill.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("13", respCode);
    }
    
    @Test
    public void testInvalid_BillIdRequest() throws Exception {
        Config.init();
        
        request.add("SEARCH_BILL_BY_PROVIDER");
        request.add("10");

        String response = searchBill.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("14", respCode);
    }
    
    @Test
    public void testValid_BillIdRequest() throws Exception {
        Config.init();
        
        request.add("SEARCH_BILL_BY_PROVIDER");
        request.add("VNPT");

        String response = searchBill.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
}
