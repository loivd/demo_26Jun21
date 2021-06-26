/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.bean;

import java.io.Serializable;

/**
 *
 * @author mrloi
 */
public class TransactionHistory implements Serializable {
    private String transactionId;
    private String transactionType;
    private String custId;
    private String topupAmount;
    private String transactionDate;
    private Bill bill;
    
    public static class Builder {
        private String transactionId;
        private String transactionType;
        private String custId;
        private String topupAmount;
        private String transactionDate;
        private Bill bill;
        
        public Builder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }
        
        public Builder withTransactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }
        
        public Builder withCustId(String custId) {
            this.custId = custId;
            return this;
        }
        
        public Builder withTopupAmount(String topupAmount) {
            this.topupAmount = topupAmount;
            return this;
        }
        
        public Builder withTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }
        
        public Builder withBill(Bill bill) {
            this.bill = bill;
            return this;
        }
        
        public TransactionHistory build() {
            TransactionHistory tranHis = new TransactionHistory();
            tranHis.setTransactionId(this.transactionId);
            tranHis.setTransactionType(this.transactionType);
            tranHis.setCustId(this.custId);
            tranHis.setTopupAmount(this.topupAmount);
            tranHis.setTransactionDate(transactionDate);
            tranHis.setBill(this.bill);
            
            return tranHis;
        }
    }
    
    private TransactionHistory() {
       //nothing here
    }

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
     * @return the bill
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    /**
     * @return the topupAmount
     */
    public String getTopupAmount() {
        return topupAmount;
    }

    /**
     * @param topupAmount the topupAmount to set
     */
    public void setTopupAmount(String topupAmount) {
        this.topupAmount = topupAmount;
    }

    /**
     * @return the transactionDate
     */
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
