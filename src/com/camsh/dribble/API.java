package com.camsh.dribble;

import java.io.*;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class API {
    static void Test() {
    	try {
	        HttpClient httpclient = new DefaultHttpClient();
	        HttpGet get = new HttpGet("http://api.dribbble.com/shots/936548");

	        HttpResponse response = httpclient.execute(get);

	        HttpEntity entity = response.getEntity();
	        BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
	        String returnedJSONString = in.readLine();
	        in.close();

            //if (Constants.DEV_MODE) Log.d(Constants.TAG, "GetMe: " + returnedJSONString);
	        Log.d("TAG", returnedJSONString);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static class getSubreddit extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... subreddit) {
        	try {
    	        HttpClient httpclient = new DefaultHttpClient();
    	        HttpGet get = new HttpGet("http://api.dribbble.com/shots/936548");

    	        HttpResponse response = httpclient.execute(get);

    	        HttpEntity entity = response.getEntity();
    	        BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
    	        String returnedJSONString = in.readLine();
    	        in.close();

                //if (Constants.DEV_MODE) Log.d(Constants.TAG, "GetMe: " + returnedJSONString);
    	        Log.d("TAG", returnedJSONString);
    	        return returnedJSONString;
        	}
        	catch (Exception e) {
    			e.printStackTrace();
    		}
			return null;
        }

        protected void onPostExecute(String result) {
            

        }
    }
}
