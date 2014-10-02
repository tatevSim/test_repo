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
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView list;
	  String[] web1 = {
	    "Random Move",
	      "Left-Right Move",
	      "Circle Focus",
	      "Blinking",
	      "Random Move",
	      "Random Move",
	      "Random Move",
	      "Random Move",
	      "Random Move",
	      "Random Move",
	      "Random Move",
	      "Random Move",
	     
	  } ;
	  String[] web2 = {"0 min",
			    "0 min",
			      "0 min",
			      "0 min",
			      "0 min",
			      
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
	      R.drawable.test_icon4,
	      R.drawable.test_icon4,
	      R.drawable.test_icon4,
	      R.drawable.test_icon4,
	      
	      
	       };

	  
	  protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.status);
		    CustomList adapter = new
		        CustomList(MainActivity.this, web1, web2, imageId);
		    list=(ListView)findViewById(R.id.list);
		        list.setAdapter(adapter);
		     
//		        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//		                @Override
//		                public void onItemClick(AdapterView<?> parent, View view,
//		                                        int position, long id) {
//		                    Toast.makeText(MainActivity.this, "You Clicked at " +web1 [+ position], Toast.LENGTH_SHORT).show();
//		                }
//		            });
		  }
		}
 
// TextView text1;
// TextView text2;
// TextView text3;
// TextView text4;
// TextView text1_is_new;
// TextView text2_is_new;
// TextView text3_is_new;
// TextView text4_is_new;
// Typeface typeface;
//
// public static final String URL = "http://www.eyeexamtest.com/images/eyecareplusbanner.png";
// private static String url = "http://www.eyeexamtest.com/en/dailytips/testing.json";
// private static final String TAG_TEST = "test_name";
// private static final String TAG_IS_NEW = "is_new";
// private static final String TAG_IS_PASSED = "is_passed";
// private ArrayList<String> buttonTexts = new ArrayList<String>();
// private ArrayList<String> buttonNew = new ArrayList<String>();
// private ArrayList<HashMap<String, String>> testList = new ArrayList<HashMap<String, String>>();
// // private ArrayList<String> buttonPassed= new ArrayList<String>();
// JSONArray contacts = null;
// ImageButton bigbutton;
//// String test, test1;
// TextView t;
//
// /** Called when the activity is first created. */
// @Override
// public void onCreate(Bundle savedInstanceState) {
//  super.onCreate(savedInstanceState);
//  setContentView(R.layout.eye_guide);
//  t= (TextView) findViewById(R.id.Carrot);
//
//  t.setOnClickListener(new OnClickListener() {
//      public void onClick(View v) {
//    	  finish();
//      }
//  });
//  
//  }
// 
// }

//  text1 = (TextView) findViewById(R.id.text1);
//  
//  text2 = (TextView) findViewById(R.id.text2);
//  text3 = (TextView) findViewById(R.id.text3);
//  text4 =(TextView) findViewById(R.id.text4);
//  text1_is_new = (TextView) findViewById(R.id.text1_is_new);
//  
//  text2_is_new= (TextView) findViewById(R.id.text2_is_new);
//  text3_is_new= (TextView) findViewById(R.id.text3_is_new);
//  text4_is_new =(TextView) findViewById(R.id.text4_is_new);
//   typeface = Typeface.createFromAsset(getAssets(),
//   "fonts/OpenSans-Regular.ttf");
//   text1.setTypeface(typeface);
//   text2.setTypeface(typeface);
//   text3.setTypeface(typeface);
//   text4.setTypeface(typeface);
//
//  bigbutton = (ImageButton) findViewById(R.id.button0);
//
//  GetXMLTask task = new GetXMLTask();
//
//  task.execute(new String[] { URL });
//  new GetContacts().execute();
// }

// private class GetContacts extends AsyncTask<Void, Void, Void> {
//
//  @Override
//  protected Void doInBackground(Void... arg0) {
//
//   ServiceHandler sh = new ServiceHandler();
//
//   String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
//   Log.d(jsonStr,"aaa");
//     
//
//   if (jsonStr != null) {
//    try {
//     JSONArray jsonArray = new JSONArray(jsonStr);
//
//     for (int i = 0; i < jsonArray.length(); i++) {
//
//      JSONObject jsonObject = jsonArray.getJSONObject(i);
//      HashMap<String, String> testMap = new HashMap<String, String>();
//
//      String item = jsonObject.getString(TAG_TEST);
//      String is_new = new String();
//      String is_passed = new String();
//      
//      if(jsonObject.has(TAG_IS_NEW)) {
//       is_new = jsonObject.getString(TAG_IS_NEW);
//      }
//      if(jsonObject.has(TAG_IS_PASSED)) {
//       is_passed=jsonObject.getString(TAG_IS_PASSED);
//      }
//      
//      
//      testMap.put(TAG_TEST, item);
//      testMap.put(TAG_IS_NEW, is_new);
//      testMap.put(TAG_IS_PASSED, is_passed);
//      testList.add(testMap);
////    Log.i("test", item);
//  
//     
//     }

     
     
     // String status1 =btn1.getString(TAG_IS_NEW);
     //
     //
     //
     //
     //
     // JSONObject btn2 = jsonObj.getJSONObject(2);
     //
     // String test2 = btn2.getString(TAG_TEST);
     // String status2 = btn2.getString(TAG_IS_NEW);
     //
     //
     // button3.setText(test2);
     //
     // JSONObject btn4 = jsonObj.getJSONObject(3);
     //
     // String test3 = btn4.getString(TAG_TEST);
     // String status3 = btn4.getString(TAG_IS_NEW);
     //
     //
     //
     // button4.setText(test);
     //

//    } catch (JSONException e) {
//     e.printStackTrace();
//    }
//   } else {
//    Log.e("ServiceHandler", "Couldn't get any data from the url");
//   }
//
//   return null;
//  }

//  @Override
//  protected void onPostExecute(Void result) {
//   if (testList != null && testList.size() == 4)
//
//   text1.setText(testList.get(0).get(TAG_TEST));
//   text2.setText(testList.get(1).get(TAG_TEST));
//   text3.setText(testList.get(2).get(TAG_TEST));
//   text4.setText(testList.get(3).get(TAG_TEST));
//
//   if (testList.get(0).get(TAG_IS_NEW).equalsIgnoreCase("true")) {
//
//    
//    text1_is_new.setText("true");
//   }
//   if (testList.get(1).get(TAG_IS_NEW).equalsIgnoreCase("true")) {
//	   text2_is_new.setText("true");
//   }
//   if (testList.get(2).get(TAG_IS_NEW).equalsIgnoreCase("true")) {
//	   text3_is_new.setText("true");
//   }
//   if (testList.get(3).get(TAG_IS_PASSED).equalsIgnoreCase("true")) {
//	   text4_is_new.setText("true");
//   }

   // button2.setText(buttonTexts.get(1));
   // button3.setText(buttonTexts.get(2));
   // button4.setText(buttonTexts.get(3));
   //
   // if (buttonNew.get(0).equalsIgnoreCase("true")) {
   // button1.setText(button1.getText().toString() + "\n" + "true");
   // }
   // if (buttonNew.get(1).equalsIgnoreCase("true")) {
   // button2.setText(button2.getText().toString() + "\n" + "true");
   // }
   // if (buttonNew.get(2).equalsIgnoreCase("true")) {
   // button3.setText(button3.getText().toString() + "\n" + "true");
   // }
   // if(buttonPassed.get(3).equalsIgnoreCase("true")){
   // button4.setText(button4.getText().toString() + "\n" + "true");}

//   super.onPostExecute(result);
//
//  }
//
// }
//
// public class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
//  @Override
//  protected Bitmap doInBackground(String... urls) {
//   Bitmap map = null;
//   for (String url : urls) {
//    map = downloadImage(url);
//   }
//   return map;
//  }
//
//  // Sets the Bitmap returned by doInBackground
//  @Override
//  protected void onPostExecute(Bitmap result) {
//   bigbutton.setImageBitmap(result);
//  }
//
//  // Creates Bitmap from InputStream and returns it
//  private Bitmap downloadImage(String url) {
//   Bitmap bitmap = null;
//   InputStream stream = null;
//   BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//   bmOptions.inSampleSize = 1;
//
//   try {
//    stream = getHttpConnection(url);
//    bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
//    stream.close();
//   } catch (IOException e1) {
//    e1.printStackTrace();
//   }
//   return bitmap;
//  }
//
//  // Makes HttpURLConnection and returns InputStream
//  private InputStream getHttpConnection(String urlString)
//    throws IOException {
//   InputStream stream = null;
//   URL url = new URL(urlString);
//   URLConnection connection = url.openConnection();
//   try {
//	    HttpURLConnection httpConnection = (HttpURLConnection) connection;
//	    httpConnection.setRequestMethod("GET");
//	    httpConnection.connect();
//
//	    if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//	     stream = httpConnection.getInputStream();
//	    }
//	   } catch (Exception ex) {
//	    ex.printStackTrace();
//	   }
//	   return stream;
//	  }
//	 }
//	}