package com.example.busterminalshipment.Model;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

@Entity
public class Shipment {
    //************************************Properties***************************************
    //public
    @PrimaryKey
    @SerializedName("XKey")
    public int XKey;

    @SerializedName("SenderCustomerXKey")
    public int SenderCustomerXKey;

    @SerializedName("ReceiverFullName")
    public String ReceiverFullName;

    @SerializedName("ReceiverMobilPhone")
    public String ReceiverMobilPhone;

    @SerializedName("ReceiverEmail")
    public String ReceiverEmail;

    @SerializedName("XPassword")
    public String XPassword;

    @SerializedName("TrackingNumber")
    public String TrackingNumber;

    @SerializedName("XDate")
    public LocalDateTime XDate;

    @SerializedName("XFrom")
    public String XFrom;

    @SerializedName("XTo")
    public String XTo;

    @SerializedName("XContent")
    public String XContent;

    @SerializedName("DeclaredAmount")
    public double DeclaredAmount;

    @SerializedName("Fee")
    public double Fee;

    @SerializedName("PayWhenReceived")
    public String PayWhenReceived;

    @SerializedName("PaymentStatus")
    public String PaymentStatus;

    @SerializedName("InvoiceXValue")
    public String InvoiceXValue;

    @SerializedName("ShipmentStatus")
    public String ShipmentStatus;

    @SerializedName("BusXKey")
    public int BusXKey;

    @SerializedName("BusDriverXKey")
    public int BusDriverXKey;

    @SerializedName("TurnXKey")
    public int TurnXKey;

    //------------------------------------------------------------------------------------
     @SerializedName("CreationDateTime")
     public LocalDateTime CreationDateTime;

    @SerializedName("CreationAuthor")
    public String CreationAuthor;

    @SerializedName("LastModificationDateTime")
    public LocalDateTime LastModificationDateTime;

    @SerializedName("LastModificationAuthor")
    public String LastModificationAuthor;
    //------------------------------------------------------------------------------------
    //AUXILIAR PROPERTIES
    /**
     @SerializedName("_Customer")
     public Customer _Customer;
     @SerializedName("_Bus")
     public Bus _Bus;
     @SerializedName("_BusDriverOrHelper")
     public BusDriverOrHelper _BusDriverOrHelper;
     //END OF AUXILIAR PROPERTIES
     */
    //****************************GETTERS AND SETTERS*************************************

    public int getXKey() {
        return XKey;
    }

    public void setXKey(int XKey) {
        this.XKey = XKey;
    }

    public int getSenderCustomerXKey() {
        return SenderCustomerXKey;
    }

    public void setSenderCustomerXKey(int senderCustomerXKey) {
        SenderCustomerXKey = senderCustomerXKey;
    }

    public String getReceiverFullName() {
        return ReceiverFullName;
    }

    public void setReceiverFullName(String receiverFullName) {
        ReceiverFullName = receiverFullName;
    }

    public String getReceiverMobilPhone() {
        return ReceiverMobilPhone;
    }

    public void setReceiverMobilPhone(String receiverMobilPhone) {
        ReceiverMobilPhone = receiverMobilPhone;
    }

    public String getReceiverEmail() {
        return ReceiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        ReceiverEmail = receiverEmail;
    }

    public String getXPassword() {
        return XPassword;
    }

    public void setXPassword(String XPassword) {
        this.XPassword = XPassword;
    }

    public String getTrackingNumber() {
        return TrackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        TrackingNumber = trackingNumber;
    }

    public LocalDateTime getXDate() {        return XDate;    }

    public void setXDate(LocalDateTime XDate) { this.XDate = XDate; }

    public String getXFrom() {return XFrom;}

    public void setXFrom(String XFrom) {
        this.XFrom = XFrom;
    }

    public String getXTo() {
        return XTo;
    }

    public void setXTo(String XTo) {
        this.XTo = XTo;
    }

    public String getXContent() {
        return XContent;
    }

    public void setXContent(String XContent) {
        this.XContent = XContent;
    }

    public double getDeclaredAmount() {
        return DeclaredAmount;
    }

    public void setDeclaredAmount(double declaredAmount) {
        DeclaredAmount = declaredAmount;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double fee) {
        Fee = fee;
    }

    public String getPayWhenReceived() {
        return PayWhenReceived;
    }

    public void setPayWhenReceived(String payWhenReceived) {
        PayWhenReceived = payWhenReceived;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    public String getInvoiceXValue() {
        return InvoiceXValue;
    }

    public void setInvoiceXValue(String invoiceXValue) {
        InvoiceXValue = invoiceXValue;
    }

    public String getShipmentStatus() {
        return ShipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        ShipmentStatus = shipmentStatus;
    }

    public int getBusXKey() {
        return BusXKey;
    }

    public void setBusXKey(int busXKey) {
        BusXKey = busXKey;
    }

    public int getBusDriverXKey() {
        return BusDriverXKey;
    }

    public void setBusDriverXKey(int busDriverXKey) {
        BusDriverXKey = busDriverXKey;
    }

    public int getTurnXKey() {
        return TurnXKey;
    }

    public void setTurnXKey(int turnXKey) {
        TurnXKey = turnXKey;
    }

    public LocalDateTime getCreationDateTime() {
      return CreationDateTime;
    }

     public void setCreationDateTime(LocalDateTime creationDateTime) {
       CreationDateTime = creationDateTime;
    }

    public String getCreationAuthor() {
        return CreationAuthor;
    }

    public void setCreationAuthor(String creationAuthor) {
        CreationAuthor = creationAuthor;
    }

    public LocalDateTime getLastModificationDateTime() {        return LastModificationDateTime;    }

    public void setLastModificationDateTime(LocalDateTime lastModificationDateTime) {
      LastModificationDateTime = lastModificationDateTime;
    }

    public String getLastModificationAuthor() {
        return LastModificationAuthor;
    }

    public void setLastModificationAuthor(String lastModificationAuthor) {
        LastModificationAuthor = lastModificationAuthor;
    }

     //AUXILIAR PROPERTIES
    /**
     public Customer get_Customer() {
     return _Customer;
     }
     public void set_Customer(Customer _Customer) {
     this._Customer = _Customer;
     }
     public Bus get_Bus() {
     return _Bus;
     }
     public void set_Bus(Bus _Bus) {
     this._Bus = _Bus;
     }
     public BusDriverOrHelper get_BusDriverOrHelper() {
     return _BusDriverOrHelper;
     }
     public void set_BusDriverOrHelper(BusDriverOrHelper _BusDriverOrHelper) {
     this._BusDriverOrHelper = _BusDriverOrHelper;
     }**/
}

//END OF AUXILIAR PROPERTIES
