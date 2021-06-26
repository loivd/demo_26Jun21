/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo;

import com.google.gson.JsonObject;
import demomomo.app.business.TransactionFactory;
import demomomo.app.config.Config;
import demomomo.app.utils.GsonUtils;
import demomomo.app.utils.Utils;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mrloi
 */
public class DemoMoMo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Config.init();
        
        TransactionFactory transaction = TransactionFactory.getInstance();
        Utils utils = new Utils();
        GsonUtils gsonUtils = new GsonUtils();
        
        System.out.println("*** Please input your request **** ");
        Boolean flag = true;
        while (flag) {
            try {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                List<String> request = utils.getRequest(input);
                if(request == null) {
                    System.out.println("Error 01 - You don't input any request!!!");
                    System.out.println("*** Please input your request again or type EXIT to exit ***");
                } else {
                    String command = request.get(0);
                    switch(command) {
                        case "CASH_IN":
                            String response = transaction.chooseTransaction("CASH_IN").doRequest(request);
                            JsonObject reObj = gsonUtils.createJsonObj(response);
                            String respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
                            String respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            System.out.println(respDesciption);
                            if("00".equals(respCode))
                                System.out.println("Your current account is: " + utils.formatCcyVnd(Config.customer.getCurrentBalance()));
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "LIST_BILL":
                            response = transaction.chooseTransaction("LIST_BILL").doRequest(request);
                            reObj = gsonUtils.createJsonObj(response);
                            respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
                            respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            if("00".equals(respCode))
                                System.out.println(respDesciption);
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "PAY":
                            response = transaction.chooseTransaction("PAY").doRequest(request);
                            reObj = gsonUtils.createJsonObj(response);
                            respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
                            respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            System.out.println(respDesciption);
                            if("00".equals(respCode))
                                System.out.println("Your current account is: " + utils.formatCcyVnd(Config.customer.getCurrentBalance()));
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "DUE_DATE":
                            response = transaction.chooseTransaction("DUE_DATE").doRequest(request);
                            reObj = gsonUtils.createJsonObj(response);
                            respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            System.out.println(respDesciption);
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "SCHEDULE":
                            response = transaction.chooseTransaction("SCHEDULE").doRequest(request);
                            reObj = gsonUtils.createJsonObj(response);
                            respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            System.out.println(respDesciption);
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "LIST_PAYMENT":
                            response = transaction.chooseTransaction("LIST_PAYMENT").doRequest(request);
                            reObj = gsonUtils.createJsonObj(response);
                            respCode = gsonUtils.getAsStringUtil(reObj, "respCode");
                            respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            if("00".equals(respCode))
                                System.out.println(respDesciption);
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "SEARCH_BILL_BY_PROVIDER":
                            response = transaction.chooseTransaction("SEARCH_BILL_BY_PROVIDER").doRequest(request);
                            reObj = gsonUtils.createJsonObj(response);
                            respDesciption = gsonUtils.getAsStringUtil(reObj, "respDesciption");
                            
                            System.out.println(respDesciption);
                            System.out.println("*** Please input your new request or type EXIT to exit ***");
                            break;
                        case "EXIT":
                            flag = false;
                            System.out.println("Good bye!");
                            break;
                        default:
                            System.out.println("Error 02 - Invalid request!!!");
                            System.out.println("*** Please input your request again or type EXIT to exit ***");
                    }
                }
            } catch(Exception ex) {
                System.out.println("System Error: " + ex.getMessage());
            }
        }
        
    }

}
