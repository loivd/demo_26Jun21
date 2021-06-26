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
public class Schedule implements Serializable {
    private String custId;
    private String billNo;
    private String scheduleDate;
    private String status;
    private String bookDate;
    
    public static class Builder {
        private String custId;
        private String billNo;
        private String scheduleDate;
        private String status;
        private String bookDate;
        
        public Builder withCustId(String custId) {
            this.custId = custId;
            return this;
        }
        
        public Builder withBillNo(String billNo) {
            this.billNo = billNo;
            return this;
        }
        
        public Builder withScheduleDate(String scheduleDate) {
            this.scheduleDate = scheduleDate;
            return this;
        }
        
        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }
        
        public Builder withBookDate(String bookDate) {
            this.bookDate = bookDate;
            return this;
        }
        
        public Schedule build() {
            Schedule schedule = new Schedule();
            schedule.setBillNo(this.billNo);
            schedule.setCustId(this.custId);
            schedule.setBillNo(this.billNo);
            schedule.setScheduleDate(this.scheduleDate);
            schedule.setStatus(this.status);
            schedule.setBookDate(this.bookDate);
            
            return schedule;
        }
    }
    
    private Schedule() {
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
     * @return the scheduleDate
     */
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * @param scheduleDate the scheduleDate to set
     */
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the bookDate
     */
    public String getBookDate() {
        return bookDate;
    }

    /**
     * @param bookDate the bookDate to set
     */
    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }
}
