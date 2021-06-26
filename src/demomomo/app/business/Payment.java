/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.business;

import com.google.gson.JsonObject;
import demomomo.app.bean.Bill;
import demomomo.app.bean.TransactionHistory;
import demomomo.app.config.Config;
import demomomo.app.utils.Utils;
import java.util.List;

/**
 *
 * @author mrloi
 */
public class Payment implements Transaction {

    @Override
    public String doRequest(List<String> request) throws Exception {
        String result;
        JsonObject data = new JsonObject();
        Utils utils = new Utils();
        
        try {
            int sizeOfParam = request.size();
            if(sizeOfParam >= 2) {
                //Validate input params
                if(!utils.validateParams(request)) {
                    data.addProperty("respCode", "06");
                    data.addProperty("respDesciption", "Bill id format is invalid!!!");
                } else {
                    //Validate available amount
                    boolean validAmount = true;
                    long totalBillAmount = 0;
                    for(int i = 1; i < sizeOfParam; i++) {
                        String billNo = request.get(i);
                        Bill bill = Config.lstBill.stream()
                                            .filter(x -> billNo.equals(x.getBillNo()))
                                            .findAny()
                                            .orElse(null);
                        if(bill == null) {
                            data.addProperty("respCode", "07");
                            data.addProperty("respDesciption", "Sorry! Not found a bill with such id.");
                            validAmount = false;
                            break;
                        } else {
                            totalBillAmount = totalBillAmount + Long.parseLong(bill.getAmount());
                        }
                    }
                    if(validAmount) {
                        long currentBalance = Long.parseLong(Config.customer.getCurrentBalance());
                        if(currentBalance < totalBillAmount) {
                            data.addProperty("respCode", "08");
                            data.addProperty("respDesciption", "Sorry! Not enough fund to proceed with payment.");
                        } else {
                            for(int i = 1; i < sizeOfParam; i++) {
                                String billNo = request.get(i);
                                Bill bill = Config.lstBill.stream()
                                            .filter(x -> billNo.equals(x.getBillNo()))
                                            .findAny()
                                            .orElse(null);
                                long billAmt = Long.parseLong(bill.getAmount());
                                long finalBalance = currentBalance - billAmt;
                                Config.customer.setCurrentBalance(String.valueOf(finalBalance));
                                bill.setState("PAID");
                                Config.lstTransaction.add(new TransactionHistory.Builder().withCustId(Config.customer.getCustId())
                                                .withTransactionType("Payment")
                                                .withTransactionDate(utils.getCurrentDateFormat())
                                                .withBill(bill)
                                                .withTransactionId(String.valueOf(Config.tranCount++)).build());
                                data.addProperty("respCode", "00");
                                data.addProperty("respDesciption", "Payment has been completed for Bill with id " + bill.getBillNo());
                            }
                        }
                    }
                }
            } else {
                data.addProperty("respCode", "05");
                data.addProperty("respDesciption", "Payment request is invalid!!!");
            }

            result = data.toString();
        } catch (Exception ex) {
            throw new Exception("doRequest - Exception: " + ex.getMessage());
        }
        return result;
    }
    
}
