package com.padcmyanmar.padc7.mmnews.data.data.agents;

public interface NewsDataAgent {

    void loadNews(int page, String accessToken);
    void login(String phoneNumber, String password);
    void register(String phoneNumber, String passwrod, String name);



}
