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
import java.util.stream.Collectors;

/**
 *
 * @author mrloi
 */
public class DueDate implements Transaction {

    @Override
    public String doRequest(List<String> request) throws Exception {
        String result;
        JsonObject data = new JsonObject();
        Utils utils = new Utils();
        
        try {
            List<Bill> lstUnpaid = Config.lstBill.stream()
                                            .filter(x -> "NOT_PAID".equals(x.getState()))
                                            .collect(Collectors.toList());
            if(lstUnpaid == null || lstUnpaid.isEmpty()) {
                data.addProperty("respCode", "15");
                data.addProperty("respDesciption", "Not found duedate bills.");
            } else {
                StringBuilder sb = new StringBuilder("Bill No.").append(utils.printFormat("Bill No."))
                .append("Type").append(utils.printFormat("Type"))
                .append("Amount").append(utils.printFormat("Amount"))
                .append("Due Date").append(utils.printFormat("Due Date"))
                .append("State").append(utils.printFormat("State"))
                .append("PROVIDER\r\n");
                
                for(Bill bill : lstUnpaid) 
                    sb.append(bill.getBillNo()).append(utils.printFormat(bill.getBillNo()))
                        .append(bill.getServiceId()).append(utils.printFormat(bill.getServiceId()))
                        .append(bill.getAmount()).append(utils.printFormat(bill.getAmount()))
                        .append(bill.getDueDate()).append(utils.printFormat(bill.getDueDate()))
                        .append(bill.getState()).append(utils.printFormat(bill.getState()))
                        .append(bill.getProviderId())
                        .append("\r\n");
                
                data.addProperty("respCode", "00");
                data.addProperty("respDesciption", sb.toString());
            }
            result = data.toString();
        } catch (Exception ex) {
            throw new Exception("doRequest - Exception: " + ex.getMessage());
        }
        return result;
    }
    
}
