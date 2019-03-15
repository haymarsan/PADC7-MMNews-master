package com.padcmyanmar.padc7.mmnews.data.vos;

public class SendToVO {

    private String sendTo_id;
    private String sentToDate;
    private UserVO send_user;
    private UserVO receive_user;

    public String getSendTo_id() {
        return sendTo_id;
    }

    public String getSentToDate() {
        return sentToDate;
    }

    public UserVO getSend_user() {
        return send_user;
    }

    public UserVO getReceive_user() {
        return receive_user;
    }
}
