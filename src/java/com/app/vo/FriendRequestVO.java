
package com.app.vo;
/**
 *
 * @author Devraj
 */
public class FriendRequestVO {
    
    int requestNo;
    int requestBy;
    String requestByName;
    String message;

    public FriendRequestVO(int requestNo, int requestBy, String requestByName, String message) {
        this.requestNo = requestNo;
        this.requestBy = requestBy;
        this.requestByName = requestByName;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(int requestBy) {
        this.requestBy = requestBy;
    }

    public String getRequestByName() {
        return requestByName;
    }

    public void setRequestByName(String requestByName) {
        this.requestByName = requestByName;
    }

    public int getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }
    
}
