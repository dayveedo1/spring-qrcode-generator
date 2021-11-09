package com.david.qrcodegen.model;

public class RequestBody {

    private String userName;
    private String mobileNumber;
    private String accountType;
    private String accountNumber;
    private String bank;

    public RequestBody() {
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
