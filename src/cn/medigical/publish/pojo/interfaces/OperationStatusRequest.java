package cn.medigical.publish.pojo.interfaces;

public class OperationStatusRequest {

    private String date;

    private String accountID;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
