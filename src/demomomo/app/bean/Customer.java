/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.bean;

/**
 *
 * @author mrloi
 */
public class Customer {
    private String custId;
    private String custName;
    private String custType;
    private String accountNo;
    private String currentBalance;
        
    public static class Builder {
        private String custId;
        private String custName;
        private String custType;
        private String accountNo;
        private String currentBalance;
        
        public Builder withCustId(String custId) {
            this.custId = custId;
            return this;
        }
        
        public Builder withCustName(String custName) {
            this.custName = custName;
            return this;
        }
        
        public Builder withCustType(String custType) {
            this.custType = custType;
            return this;
        }
        
        public Builder withAccountNo(String accountNo) {
            this.accountNo = accountNo;
            return this;
        }
        
        public Builder withCurrentBalance(String currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }
        
        public Customer build() {
            Customer customer = new Customer();
            customer.setCustId(this.custId);
            customer.setCustName(this.custName);
            customer.setCustType(this.custType);
            customer.setAccountNo(this.accountNo);
            customer.setCurrentBalance(this.currentBalance);
            return customer;
        }
    }
        
    private Customer() {
        //nothing here
    }

    /**
     * @return the custId
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(String custId) {
        this.custId = custId;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the custType
     */
    public String getCustType() {
        return custType;
    }

    /**
     * @param custType the custType to set
     */
    public void setCustType(String custType) {
        this.custType = custType;
    }

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return the currentBalance
     */
    public String getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }
}
