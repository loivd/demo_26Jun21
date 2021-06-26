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
public class ScheduleTest {
    List<String> request = new ArrayList<>();
    Schedule schedule = new Schedule();
    GsonUtils gsonUtils = new GsonUtils();
    
    public ScheduleTest() {
    }

    @Test
    public void testInvalid_ParamsRequest() throws Exception {
        request.add("SCHEDULE");

        String response = schedule.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("09", respCode);
    }
    
    @Test
    public void testInvalid_BillIdFormatRequest() throws Exception {
        Config.init();
    
        request.add("SCHEDULE");
        request.add("1AA");
        request.add("28/10/2020");

        String response = schedule.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("10", respCode);
    }
    
    @Test
    public void testInvalid_NotFoundBillIdRequest() throws Exception {
        Config.init();
    
        request.add("SCHEDULE");
        request.add("10");
        request.add("28/10/2020");

        String response = schedule.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("11", respCode);
    }
    
    @Test
    public void testInvalid_ScheduleDateFormatRequest() throws Exception {
        Config.init();
    
        request.add("SCHEDULE");
        request.add("1");
        request.add("288/10/2020");

        String response = schedule.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("12", respCode);
    }
    
    @Test
    public void testValid_Request() throws Exception {
        Config.init();
    
        request.add("SCHEDULE");
        request.add("1");
        request.add("28/10/2020");

        String response = schedule.doRequest(request);
        JsonObject reObj = gsonUtils.createJsonObj(response);
        String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
        assertEquals("00", respCode);
    }
    
}
