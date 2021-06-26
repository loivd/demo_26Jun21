/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.business;

/**
 *
 * @author mrloi
 */
public class TransactionFactory {
    private static volatile TransactionFactory instance;
    private static Object mutex = new Object();
    
    private TransactionFactory() {
    }
    
    public static TransactionFactory getInstance() {
        TransactionFactory result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new TransactionFactory();
            }
        }
        return result;
    }
    
    public Transaction chooseTransaction(String transactionType) {
        if(transactionType == null) {
            return null;
        } 
        if(transactionType.equalsIgnoreCase("CASH_IN")) {
            return new Topup();
        } else if(transactionType.equalsIgnoreCase("LIST_BILL")) {
            return new ListBill();
        } else if(transactionType.equalsIgnoreCase("PAY")) {
            return new Payment();
        } else if(transactionType.equalsIgnoreCase("DUE_DATE")) {
            return new DueDate();
        } else if(transactionType.equalsIgnoreCase("SCHEDULE")) {
            return new Schedule();
        } else if(transactionType.equalsIgnoreCase("LIST_PAYMENT")) {
            return new ListPayment();
        } else if(transactionType.equalsIgnoreCase("SEARCH_BILL_BY_PROVIDER")) {
            return new SearchBill();
        }
        return null;
    }
}
