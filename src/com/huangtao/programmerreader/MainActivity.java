package com.huangtao.programmerreader;

import android.app.Activity;
import android.os.Bundle;
import java.io.InputStream; 

import org.apache.http.HttpEntity; 
import org.apache.http.HttpResponse; 
import org.apache.http.HttpStatus; 
import org.apache.http.client.HttpClient; 
import org.apache.http.client.methods.HttpGet; 
import org.apache.http.impl.client.DefaultHttpClient; 
 
import android.content.Intent; 
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory; 
import android.os.AsyncTask; 
import android.util.Log; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.ImageView; 
import android.widget.ProgressBar; 
 
public class MainActivity extends Activity { 
 
    private Button execute; 
 
    private Button startButton; 
 
    private ProgressBar progressBar; 
     
    private MyTask myTask; 
     
    private ImageView imageView; 
     
    private static final String TAG="Async Task"; 
 
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
         
        execute = (Button)this.findViewById(R.id.execute); 
         
        execute.setOnClickListener( new OnClickListener() 
        { 
 
            @Override 
            public void onClick(View v) { 
                // TODO Auto-generated method stub 
                myTask = new MyTask(); 
                myTask.execute("http://pic2.ooopic.com/01/26/61/83bOOOPIC72.jpg"); 
                execute.setEnabled(false); 
                startButton.setEnabled(true); 
            } 
         
        }); 
         
        startButton = (Button)this.findViewById(R.id.startActivity); 
        startButton.setOnClickListener(new OnClickListener() 
        { 
 
            @Override 
            public void onClick(View v) { 
                // TODO Auto-generated method stub 
                Intent intent = new Intent(); 
                intent.setClass(MainActivity.this, LoadingActivity.class); 
                startActivity(intent); 
            } 
             
        }); 
         
        progressBar = (ProgressBar)this.findViewById(R.id.progress_bar); 
        imageView = (ImageView)this.findViewById(R.id.image_view); 
 
    } 
 
    private class MyTask extends AsyncTask<String, Integer, Bitmap> { 
 
        protected void onPreExecute() { 
            Log.i(TAG, "onPreExecute called"); 
        } 
 
        @Override 
        protected Bitmap doInBackground(String... params) { 
            // TODO Auto-generated method stub 
            Log.i(TAG,"doInBackground"); 
            try { 
                HttpClient client = new DefaultHttpClient(); 
                HttpGet get = new HttpGet(params[0]); 
                HttpResponse response = client.execute(get); 
                if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) 
                { 
                    HttpEntity entity = response.getEntity(); 
                    InputStream is = entity.getContent(); 
                                 
                    return BitmapFactory.decodeStream(is); 
                     
                } 
            } catch (Exception e) { 
                // TODO Auto-generated catch block 
                Log.e(TAG,e.getMessage()); 
            } 
            return null; 
        } 
 
        protected void onProgressUpdate(Integer... values) { 
            Log.i(TAG, "onProgressUpdate"); 
            progressBar.setProgress(values[0]); 
        } 
         
        protected void onPostExecute(Bitmap result) { 
             
            Log.i(TAG, "onPostExecute"); 
            imageView.setImageBitmap(result); 
            execute.setEnabled(true); 
            startButton.setEnabled(true); 
            progressBar.setProgress(0); 
             
        } 
 
    } 
} 