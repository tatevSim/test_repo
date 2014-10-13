package com.example.imglayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import com.example.imglayout.R;

import CustomList.CustomList;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Status extends Activity implements OnClickListener {
 int currentLayout;
   ListView list;
     String[] web1 = {
       "Random Move",
         "Left-Right Move",
         "Circle Focus",
         "Blinking",
         "Circle Focus",
         "Closing Tight",
         "Closed Eye Move",
         "Palming",
        
        
     } ;
     String[] web2 = {"0 min",
         "0 min",
           "0 min",
           "0 min",
           "0 min",
           
           "0 min",
           "0 min",
           "0 min",
          
          
       } ;
     Integer[] imageId = {
         R.drawable.test_icon4,
         R.drawable.test_icon4,
         R.drawable.test_icon4,
         R.drawable.test_icon4,
         R.drawable.test_icon4,
         R.drawable.test_icon4,
         R.drawable.test_icon4,
         R.drawable.test_icon4,
       
         
          };
     String[] web1Test = {
          "Visual Acuity",
            "Astigmatism ",
            "Contrast Sensitivity",
            "Central Vision",
            "Red Desaturation ",
            "Color Blindness",
            "Duochrome Acuity",
            
           
        } ;
        String[] web2Test = {"0 min",
            "0 min",
              "0 min",
              "0 min",
              "0 min",
              
              "0 min",
              "0 min",
              
             
          } ;
        Integer[] imageIdTest = {
            R.drawable.test_icon4,
            R.drawable.test_icon4,
            R.drawable.test_icon4,
            R.drawable.test_icon4,
            R.drawable.test_icon4,
            R.drawable.test_icon4,
            R.drawable.test_icon4,
           
            
            
             };
     LinearLayout training;
     
     LinearLayout test;
     
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        CustomList adapter = new
            CustomList(Status.this, web1, web2, imageId);
        list=(ListView)findViewById(R.id.list);
            list.setAdapter(adapter);
        
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(Status.this, "You Clicked at " +web1 [+ position], Toast.LENGTH_SHORT).show();
                   }
                });
          training = (LinearLayout)findViewById(R.id.training);

          training.setBackgroundColor(getResources().getColor(R.color.green1));
             test = (LinearLayout)findViewById(R.id.test);
            
      training.setOnClickListener(this);
      test.setOnClickListener(this);

 }


   @Override
   public void onClick(View v) {
    switch (v.getId()) {
    case R.id.training:
    
    
     training.setBackgroundColor(getResources().getColor(R.color.green1));
     test.setBackgroundColor(getResources().getColor(R.color.LayoutColor));
     if(currentLayout==R.id.test){
     currentLayout=R.id.training;}
     CustomList adapter = new
             CustomList(Status.this, web1, web2, imageId);
         list=(ListView)findViewById(R.id.list);
             list.setAdapter(adapter);
         
             list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                     public void onItemClick(AdapterView<?> parent, View view,
                                             int position, long id) {
                         Toast.makeText(Status.this, "You Clicked at " +web1 [+ position], Toast.LENGTH_SHORT).show();
                    }
                 });
    
     break;
    
    case R.id.test:
     
     test.setBackgroundColor(getResources().getColor(R.color.green1));
     training.setBackgroundColor(getResources().getColor(R.color.LayoutColor));
     CustomList adapterTest = new
             CustomList(Status.this, web1Test, web2Test, imageIdTest);
         list=(ListView)findViewById(R.id.list);
             list.setAdapter(adapterTest);
         
             list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                     public void onItemClick(AdapterView<?> parent, View view,
                                             int position, long id) {
                         Toast.makeText(Status.this, "You Clicked at " +web1 [+ position], Toast.LENGTH_SHORT).show();
                    }
                 });
   
    if(currentLayout==R.id.training){
     currentLayout=R.id.test;}
    
     break;
    }
    
    
    
    
   }
}