package licancan.com.comicdemo.requestUtils;

import android.icu.util.ULocale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by robot on 2017/8/18.
 */

public class RequestNews{

    public static String getNews(String Url)
    {
        StringBuffer result=new StringBuffer();
        try {
            URL url=new URL(Url);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            System.out.println("connection = " + connection);
            if(200==connection.getResponseCode())
            {
                InputStream inputStream=connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
                String line=null;
                while((line=reader.readLine())!=null)
                {
                    result.append(line);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
