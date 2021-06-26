/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.business;

import com.google.gson.JsonObject;
import demomomo.app.bean.Bill;
import demomomo.app.config.Config;
import demomomo.app.utils.Utils;
import java.util.List;

/**
 *
 * @author mrloi
 */
public class Schedule implements Transaction {

    @Override
    public String doRequest(List<String> request) throws Exception {
        String result;
        JsonObject data = new JsonObject();
        Utils utils = new Utils();
        
        try {
            int sizeOfParam = request.size();
            if(sizeOfParam == 3) {
                String param2 = request.get(1);
                if(utils.validateNumericInput(param2)) {
                    Bill bill = Config.lstBill.stream()
                                        .filter(x -> param2.equals(x.getBillNo()))
                                        .findAny()
                                        .orElse(null);
                    if(bill == null) {
                        data.addProperty("respCode", "11");
                        data.addProperty("respDesciption", "Sorry! Not found a bill with such id.");
                    } else {
                        String param3 = request.get(2);
                        if(utils.validInputDateTime(param3)) {
                            Config.lstSchedule.add(new demomomo.app.bean.Schedule.Builder().withBillNo(param2)
                                                            .withCustId(Config.customer.getCustId())
                                                            .withScheduleDate(param3)
                                                            .withBookDate(utils.getCurrentDateFormat())
                                                            .withStatus("A").build());
                            data.addProperty("respCode", "00");
                            data.addProperty("respDesciption", "Payment for bill id " + param2 + " is scheduled on " + param3);
                        } else {
                            data.addProperty("respCode", "12");
                            data.addProperty("respDesciption", "Schedule request - schedule date is invalid format!!!");
                        }
                    }
                } else {
                    data.addProperty("respCode", "10");
                    data.addProperty("respDesciption", "Schedule request - bill no is invalid format!!!");
                }
            } else {
                data.addProperty("respCode", "09");
                data.addProperty("respDesciption", "Schedule request is invalid!!!");
            }
            result = data.toString();
        } catch (Exception ex) {
            throw new Exception("doRequest - Exception: " + ex.getMessage());
        }
        return result;
    }
    
}
