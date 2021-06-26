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
public class ListPayment implements Transaction {

    @Override
    public String doRequest(List<String> request) throws Exception {
        String result;
        JsonObject data = new JsonObject();
        Utils utils = new Utils();
        
        try {
            StringBuilder sb = new StringBuilder("No.").append(utils.printFormat("No."))
                                        .append("Tran Type").append(utils.printFormat("Tran Type"))
                                        .append("Amount").append(utils.printFormat("Amount"))
                                        .append("Bill id").append(utils.printFormat("Bill id"))
                                        .append("Tran Date").append(utils.printFormat("Tran Date")).append("\r\n");
            for(TransactionHistory tran : Config.lstTransaction) {
                sb.append(tran.getTransactionId()).append(utils.printFormat(tran.getTransactionId()))
                    .append(tran.getTransactionType()).append(utils.printFormat(tran.getTransactionType()));
                if("Topup".equals(tran.getTransactionType())) {
                    sb.append(tran.getTopupAmount()).append(utils.printFormat(tran.getTopupAmount()));
                    sb.append(utils.printFormat(""));
                } else if(tran.getBill() != null) {
                    sb.append(tran.getBill().getAmount()).append(utils.printFormat(tran.getBill().getAmount()));
                    sb.append(tran.getBill().getBillNo()).append(utils.printFormat(tran.getBill().getBillNo()));
                } else {
                    sb.append(utils.printFormat(""));
                    sb.append(utils.printFormat(""));
                }   
                sb.append(tran.getTransactionDate()).append(utils.printFormat(tran.getTransactionDate()))
                    .append("\r\n");
            }
            data.addProperty("respCode", "00");
            data.addProperty("respDesciption", sb.toString());
            result = data.toString();
        } catch (Exception ex) {
            throw new Exception("doRequest - Exception: " + ex.getMessage());
        }
        return result;
    }
    
}
