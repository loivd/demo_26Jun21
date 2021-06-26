/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.config;

import demomomo.app.bean.Bill;
import demomomo.app.bean.Customer;
import demomomo.app.bean.Schedule;
import demomomo.app.bean.TransactionHistory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrloi
 */
public class Config {
    public static Customer customer;
    public static List<Bill> lstBill;
    public static int numberOfSpace;
    public static List<TransactionHistory> lstTransaction;
    public static long tranCount;
    public static List<Schedule> lstSchedule;
    
    public static void init() {
        customer = new Customer.Builder().withCustId("1")
                                        .withCustName("Nguyen Van A")
                                        .withCustType("Khach Hang Ca Nhan")
                                        .withAccountNo("000000686868")
                                        .withCurrentBalance("0").build();
        
        Bill bill1 = new Bill.Builder().withBillNo("1")
                                    .withServiceId("ELECTRIC")
                                    .withAmount("200000")
                                    .withDueDate("25/10/2020")
                                    .withState("NOT_PAID")
                                    .withProviderId("EVN HCMC").build();
        Bill bill2 = new Bill.Builder().withBillNo("2")
                                    .withServiceId("WATER")
                                    .withAmount("175000")
                                    .withDueDate("30/10/2020")
                                    .withState("NOT_PAID")
                                    .withProviderId("SAVACO HCMC").build();
        
        Bill bill3 = new Bill.Builder().withBillNo("3")
                                    .withServiceId("INTERNET")
                                    .withAmount("800000")
                                    .withDueDate("30/11/2020")
                                    .withState("NOT_PAID")
                                    .withProviderId("VNPT").build();
        
        lstBill = new ArrayList<>();
        lstBill.add(bill1);
        lstBill.add(bill2);
        lstBill.add(bill3);
        
        numberOfSpace = 15;
        
        lstTransaction = new ArrayList<>();
        tranCount = 0;
        
        lstSchedule = new ArrayList<>();
    }
}
