package com.padcmyanmar.padc7.mmnews.data.vos;

public class CommentVO {

    private String comment_id;
    private String comment;
    private String comment_date;
    private UserVO act_user;


    public String getComment_id() {
        return comment_id;
    }

    public String getComment() {
        return comment;
    }

    public String getComment_date() {
        return comment_date;
    }

    public UserVO getAct_user() {
        return act_user;
    }
}
