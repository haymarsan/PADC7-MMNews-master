package com.padcmyanmar.padc7.mmnews.network;

public interface NewsDataAgent {

    void loadNews (int page, String accessToken);
    void login (String phoneNumber, String password);
    void register (String phoneNumber, String name, String password);

}
