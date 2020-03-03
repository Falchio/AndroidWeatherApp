package ru.skillsnet.falchio.parsers;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class JsonTask extends AsyncTask<String, String, String> {

    protected String doInBackground(String... params) {

        HttpsURLConnection connection = null;
        BufferedReader reader = null;

        try {
            final URL url = new URL(params[0]);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            int i = 0;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            return buffer.toString();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return "{\"cod\":\"404\",\"message\":\"City not found\"}";
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"cod\":\"404\",\"message\":\"Fail connection\"}";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

    }


}
