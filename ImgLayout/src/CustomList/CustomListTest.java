package CustomList;

import com.example.imglayout.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomListTest extends ArrayAdapter<String>{
private final Activity context;
private final String[] web1Test;
private final String[] web2Test;
private final Integer[] imageIdTest;
public CustomListTest(Activity context,
String[] web1Test, String[] web2Test,Integer[] imageIdTest) {
super(context, R.layout.list_single, web1Test);
this.context = context;
this.web1Test = web1Test;
this.web2Test = web2Test;
this.imageIdTest = imageIdTest;
}
@Override
public View getView(int position, View view, ViewGroup parent) {
LayoutInflater inflater = context.getLayoutInflater();
View rowView= inflater.inflate(R.layout.list_single, null, true);
TextView txtTitle1 = (TextView) rowView.findViewById(R.id.txt1);
TextView txtTitle2 = (TextView) rowView.findViewById(R.id.txt2);
ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
txtTitle1.setText(web1Test[position]);
txtTitle2.setText(web2Test[position]);
imageView.setImageResource(imageIdTest[position]);
return rowView;
}
}