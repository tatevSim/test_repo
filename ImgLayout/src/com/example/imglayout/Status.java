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

	public class Status extends Activity {
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

}
}