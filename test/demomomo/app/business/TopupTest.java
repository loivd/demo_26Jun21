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
public class TopupTest {

    List<String> request = new ArrayList<>();
    Topup topup = new Topup();
    GsonUtils gsonUtils = new GsonUtils();

    public TopupTest() {
    }

    @Test
    public void testInvalid_LackParamsRequest() throws Exception {
        request.add("CASH_IN");

        String response = topup.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("03", respCode);
    }

    @Test
    public void testInvalid_OddParamsRequest() throws Exception {
        request.add("CASH_IN");
        request.add("Param2");
        request.add("Param3");

        String response = topup.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("03", respCode);
    }

    @Test
    public void testInvalid_MoneyRequest() throws Exception {
        request.add("CASH_IN");
        request.add("1000A");

        String response = topup.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("04", respCode);
    }

    @Test
    public void testValid_Request() throws Exception {
        Config.init();
    
        request.add("CASH_IN");
        request.add("1000000");

        String response = topup.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }

}
