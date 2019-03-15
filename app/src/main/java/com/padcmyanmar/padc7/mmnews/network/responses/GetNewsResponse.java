package com.padcmyanmar.padc7.mmnews.network.responses;

import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;

import java.util.List;

public class GetNewsResponse {

    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<NewsVO> newsList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }
}
