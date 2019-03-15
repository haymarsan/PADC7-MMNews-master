package com.padcmyanmar.padc7.mmnews.data.models;

import com.padcmyanmar.padc7.mmnews.data.vos.CommentVO;
import com.padcmyanmar.padc7.mmnews.data.vos.FavouriteVO;
import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.data.vos.SendToVO;

import java.util.HashMap;
import java.util.Map;

public class NewsModelImpl extends BaseModel implements NewsModel {


    private NewsModelImpl objInstance;

    private Map<String, NewsVO> mNews;




    private NewsModelImpl(){
            mNews = new HashMap<>();

    } // need private cons to set up SP


    public NewsModelImpl getObjInstance() {
        if (objInstance == null){

            objInstance = new NewsModelImpl();

        }
        return objInstance;
    }



    @Override
    public void addCommentNews(NewsVO news, CommentVO comment) {

    }

    @Override
    public void favouriteNews(NewsVO news, FavouriteVO favourite) {

    }

    @Override
    public void sendNewsTo(NewsVO news, SendToVO sendTo) {

    }
}
