/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.business;

import com.google.gson.JsonObject;
import demomomo.app.bean.TransactionHistory;
import demomomo.app.config.Config;
import demomomo.app.utils.Utils;
import java.util.List;

/**
 *
 * @author mrloi
 */
public class Topup implements Transaction {

    @Override
    public String doRequest(List<String> request) throws Exception {
        String result;
        JsonObject data = new JsonObject();
        Utils utils = new Utils();
        
        try {
            int sizeOfParam = request.size();
            if(sizeOfParam == 2) {
                String param2 = request.get(1);
                if(utils.validateNumericInput(param2)) {
                    long topupAmt = Long.parseLong(param2);
                    long currentBalance = Long.parseLong(Config.customer.getCurrentBalance());
                    long totalBalance = currentBalance + topupAmt;
                    Config.customer.setCurrentBalance(String.valueOf(totalBalance));
                    Config.lstTransaction.add(new TransactionHistory.Builder().withCustId(Config.customer.getCustId())
                                                        .withTransactionType("Topup")
                                                        .withTopupAmount(param2)
                                                        .withTransactionDate(utils.getCurrentDateFormat())
                                                        .withTransactionId(String.valueOf(Config.tranCount++)).build());
                    data.addProperty("respCode", "00");
                    data.addProperty("respDesciption", "Topup Successful!!!");
                } else {
                    data.addProperty("respCode", "04");
                    data.addProperty("respDesciption", "Money format is invalid!!!");
                }
            } else {
                data.addProperty("respCode", "03");
                data.addProperty("respDesciption", "Topup request is invalid!!!");
            }

            result = data.toString();
        } catch (Exception ex) {
            throw new Exception("doRequest - Exception: " + ex.getMessage());
        }
        return result;
    }
    
}
