package ru.skillsnet.falchio.parsers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urlImage = urls[0];
        Bitmap icon = null;
        try(InputStream in = new java.net.URL(urlImage).openStream()) {
            icon = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("DOWNLOAD IMAGE ERROR", e.getMessage());
            e.printStackTrace();
        }
        return icon;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}