package com.padcmyanmar.padc7.mmnews.data.data.agents;

import android.os.AsyncTask;
import android.util.Log;

import com.padcmyanmar.padc7.mmnews.data.vos.NewsVO;
import com.padcmyanmar.padc7.mmnews.network.responses.GetNewsResponse;
import com.padcmyanmar.padc7.mmnews.utils.CommomInstances;
import com.padcmyanmar.padc7.mmnews.utils.NewsConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDataAgent implements NewsDataAgent {


    // Singleton Pattern Setup
    private static HttpUrlConnectionDataAgent objInstance;

    private HttpUrlConnectionDataAgent() {
    }

    public static HttpUrlConnectionDataAgent getObjInstance() {
        if (objInstance == null){
            objInstance = new HttpUrlConnectionDataAgent();
        }
        return objInstance;
    }





    @Override
    public void loadNews(int page, String accessToken) {

    }

    @Override
    public void login(String phoneNumber, String password) {

    }

    @Override
    public void register(String phoneNumber, String passwrod, String name) {

    }


    // static nested class // <Void (param for doInBG, progress in onPostExecute, response type)>
    private static class AsyncApiInvoker extends AsyncTask<Void, Void, List<NewsVO>> {



        @Override
        protected List<NewsVO> doInBackground(Void... voids) {

            URL url;
            BufferedReader reader = null;
            BufferedWriter writer;
            StringBuilder stringBuilder;


            // 1) create the HttpURLConn;
            //http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php

            try {
                url = new URL(NewsConstants.NEWS_BASE_URL + NewsConstants.API_GET_NEWS_LIST); // step 1

                // 2). create HttpURLConn OBJ
                HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //2


                // 3). what method want to do an Http (POST Method Here)

                connection.setRequestMethod("POST"); //3

                // 4). read / write timeout define here
                // give it 15 sec to respond
                connection.setReadTimeout(15* 1000); //4. ms


                // 5).uncomment this if you want to write output to this url
                //connection.setDoOutput(true);

                connection.setDoInput(true); // 5
                connection.setDoOutput(true);


                // 6). Request Param which need to pass when API Call (K,V) pair
                //put the request parameter into NameValuePair list.
                List<NameValuePair> params = new ArrayList<>(); // 6
                params.add(new BasicNameValuePair(NewsConstants.PARAM_PAGE,
                        NewsConstants.PAGE));
                params.add(new BasicNameValuePair(NewsConstants.PARAM_ACCESS_TOKEN,
                        NewsConstants.ACCESS_TOKEN));

                // 7). to invoke connection need "output stream", call with (K,V) pair
                //write the parameters from NameValuePair list into connection obj.

                OutputStream outputStream = connection.getOutputStream();
                writer = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"));

                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();

                connection.connect(); // 7 ***


                // 8). read the output from the server (on connection OBJ)

               reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // 8
                stringBuilder = new StringBuilder();

                String line = null;

                while ((line = reader.readLine()) != null){

                    stringBuilder.append(line + "\n");
                }


                String responseString = stringBuilder.toString(); // 9


                GetNewsResponse getNewsResponse = CommomInstances.getGsonInstance()
                        .fromJson(responseString, GetNewsResponse.class);
                List<NewsVO> newsList = getNewsResponse.getNewsList();

                return newsList;


            } catch (Exception e) {
                Log.e("MyanmarAttractionsApp", e.getMessage());
                //e.printStackTrace();
            }
            finally {
                // close the reader; this can throw an exception too, so
                // wrap it in another try/catch block.

                if (reader != null){
                    try {
                        reader.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }


            return null;
        }

        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (NameValuePair nameValuePair : params){

                if (first){
                    first = false;
                }else {
                    result.append("&");
                    result.append(URLEncoder.encode(nameValuePair.getName(), "UTF-8"));
                    result.append("=");
                    result.append(URLEncoder.encode(nameValuePair.getValue(), "UTF-8"));

                }

            }



            return result.toString();


        }


        @Override
        protected void onPostExecute(List<NewsVO> newsVOS) {
            super.onPostExecute(newsVOS);
        }
    }



}
