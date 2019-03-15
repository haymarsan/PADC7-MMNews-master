package com.padcmyanmar.padc7.mmnews.data.vos;

import java.util.ArrayList;
import java.util.List;

public class NewsVO {

    private String news_id;
    private String brief;
    private String details;
    private List<String> images;
    private String posted_date;
    private PublicationVO publicationVO;
    private List<FavouriteVO> favourite;
    private List<CommentVO> comment;
    private List<SendToVO> sent_to;


    public String getNews_id() {
        return news_id;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getImages() {
        return images;
    }

    public String getPosted_date() {
        return posted_date;
    }

    public PublicationVO getPublicationVO() {
        return publicationVO;
    }

    public List<FavouriteVO> getFavourite() {
        return favourite;
    }

    public List<CommentVO> getComment() {
        return comment;
    }

    public List<SendToVO> getSent_to() {
        return sent_to;
    }
}


