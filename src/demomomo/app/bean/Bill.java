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
public class Bill implements Serializable {
    private String billNo;
    private String serviceId;
    private String providerId;
    private String amount;
    private String dueDate;
    private String state;
    
    public static class Builder {
        private String billNo;
        private String serviceId;
        private String providerId;
        private String amount;
        private String dueDate;
        private String state;
        
        public Builder withBillNo(String billNo) {
            this.billNo = billNo;
            return this;
        }
        
        public Builder withServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }
        
        public Builder withProviderId(String providerId) {
            this.providerId = providerId;
            return this;
        }
        
        public Builder withAmount(String amount) {
            this.amount = amount;
            return this;
        }
        
        public Builder withDueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }
        
        public Builder withState(String state) {
            this.state = state;
            return this;
        }
        
        public Bill build() {
            Bill bill = new Bill();
            bill.setBillNo(this.billNo);
            bill.setServiceId(this.serviceId);
            bill.setProviderId(this.providerId);
            bill.setAmount(this.amount);
            bill.setDueDate(this.dueDate);
            bill.setState(this.state);
            
            return bill;
        }
    }
    
    private Bill() {
       //nothing here
    }

    /**
     * @return the billNo
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * @param billNo the billNo to set
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * @return the serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the providerId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * @param providerId the providerId to set
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
}
