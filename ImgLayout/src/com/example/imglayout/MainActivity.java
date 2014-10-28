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



import com.example.imglayout.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.ImageButton;

import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	TextView text1;
	TextView text2;
	TextView text3;
	TextView text4;
	TextView text1_is_new;
	TextView text2_is_new;
	TextView text3_is_new;
	TextView text4_is_new;
	Typeface typeface;

	public static final String URL = "http://www.eyeexamtest.com/images/eyecareplusbanner.png";
 
	private static final String TAG_TEST = "test_name";
	private static final String TAG_IS_NEW = "is_new";
	private static final String TAG_IS_PASSED = "is_passed";
	private ArrayList<String> buttonTexts = new ArrayList<String>();
	private ArrayList<String> buttonNew = new ArrayList<String>();
	private ArrayList<HashMap<String, String>> testList = new ArrayList<HashMap<String, String>>();
	private ArrayList<String> buttonPassed = new ArrayList<String>();
	JSONArray contacts = null;
	ImageButton bigbutton;
	String test, test1;
	TextView t;

	// @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		RelativeLayout status = (RelativeLayout) findViewById(R.id.button3);
		RelativeLayout eyeguide = (RelativeLayout) findViewById(R.id.button4);
		RelativeLayout planning = (RelativeLayout) findViewById(R.id.button2);

		View.OnClickListener handler = new View.OnClickListener() {

			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.button3:
					Log.d("aaaa", "bbbbbbbbbbbb");
					startActivity(new Intent(MainActivity.this, Status.class));
					break;
				case R.id.button4:
					startActivity(new Intent(MainActivity.this, EyeGuide.class));
					break;
				case R.id.button2:
					
					startActivity(new Intent(MainActivity.this, Planning.class));
					break;
				}
			}
		};

		status.setOnClickListener(handler);
		eyeguide.setOnClickListener(handler);
		planning.setOnClickListener(handler);

		text1 = (TextView) findViewById(R.id.text1);

		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		text4 = (TextView) findViewById(R.id.text4);
		text1_is_new = (TextView) findViewById(R.id.text1_is_new);

		text2_is_new = (TextView) findViewById(R.id.text2_is_new);
		text3_is_new = (TextView) findViewById(R.id.text3_is_new);
		text4_is_new = (TextView) findViewById(R.id.text4_is_new);
		typeface = Typeface.createFromAsset(getAssets(),
				"fonts/OpenSans-Regular.ttf");
		text1.setTypeface(typeface);
		text2.setTypeface(typeface);
		text3.setTypeface(typeface);
		text4.setTypeface(typeface);

		bigbutton = (ImageButton) findViewById(R.id.button0);

		GetXMLTask task = new GetXMLTask();

		task.execute(new String[] { URL });
		new GetContacts().execute();
	}

	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {

			ServiceHandler sh = new ServiceHandler();

			String jsonStr = sh.makeServiceCall(URL, ServiceHandler.GET);
			Log.d(jsonStr, "aaa");

			if (jsonStr != null) {
				try {
					JSONArray jsonArray = new JSONArray(jsonStr);
					for (int i = 0; i < jsonArray.length(); i++) {

						JSONObject jsonObject = jsonArray.getJSONObject(i);
						HashMap<String, String> testMap = new HashMap<String, String>();

						String item = jsonObject.getString(TAG_TEST);
						String is_new = new String();
						String is_passed = new String();

						if (jsonObject.has(TAG_IS_NEW)) {
							is_new = jsonObject.getString(TAG_IS_NEW);
						}
						if (jsonObject.has(TAG_IS_PASSED)) {
							is_passed = jsonObject.getString(TAG_IS_PASSED);
						}

						testMap.put(TAG_TEST, item);
						testMap.put(TAG_IS_NEW, is_new);
						testMap.put(TAG_IS_PASSED, is_passed);
						testList.add(testMap);
						Log.i("test", item);

					}

					JSONObject btn2 = jsonArray.getJSONObject(2);

					String test2 = btn2.getString(TAG_TEST);
					String status2 = btn2.getString(TAG_IS_NEW);

					JSONObject btn4 = jsonArray.getJSONObject(3);

					String test3 = btn4.getString(TAG_TEST);
					String status3 = btn4.getString(TAG_IS_NEW);

				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (testList != null && testList.size() == 4)

				text1.setText(testList.get(0).get(TAG_TEST));
			text2.setText(testList.get(1).get(TAG_TEST));
			text3.setText(testList.get(2).get(TAG_TEST));
			text4.setText(testList.get(3).get(TAG_TEST));

			if (testList.get(0).get(TAG_IS_NEW).equalsIgnoreCase("true")) {

				text1_is_new.setText("true");
			}
			if (testList.get(1).get(TAG_IS_NEW).equalsIgnoreCase("true")) {
				text2_is_new.setText("true");
			}
			if (testList.get(2).get(TAG_IS_NEW).equalsIgnoreCase("true")) {
				text3_is_new.setText("true");
			}
			if (testList.get(3).get(TAG_IS_PASSED).equalsIgnoreCase("true")) {
				text4_is_new.setText("true");
			}

			super.onPostExecute(result);

		}

	}

	public class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
		@Override
		protected Bitmap doInBackground(String... urls) {
			Bitmap map = null;
			for (String url : urls) {
				map = downloadImage(url);
			}
			return map;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			bigbutton.setImageBitmap(result);
		}

		private Bitmap downloadImage(String url) {
			Bitmap bitmap = null;
			InputStream stream = null;
			BitmapFactory.Options bmOptions = new BitmapFactory.Options();
			bmOptions.inSampleSize = 1;

			try {
				stream = getHttpConnection(url);
				bitmap = BitmapFactory.decodeStream(stream, null, bmOptions);
				stream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return bitmap;
		}

		private InputStream getHttpConnection(String urlString)
				throws IOException {
			InputStream stream = null;
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			try {
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				httpConnection.setRequestMethod("GET");
				httpConnection.connect();

				if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					stream = httpConnection.getInputStream();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return stream;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}