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
public class ListBillTest {
    List<String> request = new ArrayList<>();
    ListBill listBill = new ListBill();
    GsonUtils gsonUtils = new GsonUtils();
    
    public ListBillTest() {
    }

    @Test
    public void testValid_OddParamsRequest() throws Exception {
        Config.init();
        
        request.add("LIST_BILL");
        request.add("Param2");
        
        String response = listBill.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
    @Test
    public void testValid_Request() throws Exception {
        Config.init();
        
        request.add("LIST_BILL");
        
        String response = listBill.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
}
