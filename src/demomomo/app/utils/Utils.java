/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.utils;

import demomomo.app.config.Config;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mrloi
 */
public class Utils {
    public List<String> getRequest(String input) {
        List<String> result;
        if (input == null || input.isEmpty()) {
            result = null;
        } else {
            result = Arrays.asList(input.split(" "));
        }
        return result;
    }
    
    public Boolean validateNumericInput(String input) {
        if(input == null)
            return false;
        
        String regex = "\\d+";
        return input.matches(regex);
    }
    
    //validInputDateTime "dd/mm/yyyy"
    public boolean validInputDateTime(String requestDateTime) {
        String DATETIME_PATTERN = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
        Pattern pattern = Pattern.compile(DATETIME_PATTERN);
        Matcher matcher = pattern.matcher(requestDateTime);
        return matcher.matches();
    }
    
    public String formatCcyVnd(String amount) {
        try {
            if(amount == null) {
                return null;
            } else if (!"0".equals(amount)) {
                String pattern = "#,###";
                NumberFormat format = new DecimalFormat(pattern);
                String output = format.format(Double.parseDouble(amount));
                return output;
            } else {
                return "0";
            }
        } catch (Exception ex) {
            return "";
        }
    }
    
    public String getCurrentDateFormat() {
        return new SimpleDateFormat("dd-MM-YYYY HH:mm:ss").format(new Date());
    }
    
    public String printFormat(String input) {
        String result = "";
        if(input == null)
            result = "";
        else {
            int inputLength = input.length();
            if(inputLength < Config.numberOfSpace) {
                int totalSapce = Config.numberOfSpace - inputLength;
                for(int i = 0; i < totalSapce; i++)
                    result = result + " ";
            }
        }
        return result;
    }
    
    public Boolean validateParams(List<String> params) {
        Boolean result = true;
        if(params == null)
            result = false;
        else {
            int size = params.size();
            for(int i = 1; i < size; i++)
                if(!validateNumericInput(params.get(i))) {
                    result = false;
                    break;
                }
        }
        return result;
    }

    public static void main(String[] args) {
        Utils util = new Utils();
        System.out.println(util.validInputDateTime("25/06/2021"));
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        List<String> result = util.getRequest(s);
//        System.out.println("You entered string " + s);

    }
}
