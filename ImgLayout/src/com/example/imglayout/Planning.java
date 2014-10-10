package com.example.imglayout;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.imglayout.R;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract.Colors;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class Planning extends ActionBarActivity {

	int count = 0;

	Calendar c = Calendar.getInstance();
	int phour = c.get(Calendar.HOUR_OF_DAY);
	int pminute = c.get(Calendar.MINUTE);
	String time = phour + "" + ":" + pminute + "";
	String days;
	TextView countofdays;
	private SharedPreferences sharedPreferences;
	private boolean wasEdited = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.planning);
		countofdays = (TextView) findViewById(R.id.daycount);

		ViewHolder.mon = (ToggleButton) findViewById(R.id.toggMon);
		ViewHolder.tue = (ToggleButton) findViewById(R.id.toggTue);
		ViewHolder.wed = (ToggleButton) findViewById(R.id.toggWed);
		ViewHolder.thu = (ToggleButton) findViewById(R.id.toggThu);
		ViewHolder.fri = (ToggleButton) findViewById(R.id.toggFri);
		ViewHolder.sat = (ToggleButton) findViewById(R.id.toggSat);
		ViewHolder.sun = (ToggleButton) findViewById(R.id.toggSun);
		ViewHolder.mon.setOnCheckedChangeListener(toggleButtonListener);
		ViewHolder.tue.setOnCheckedChangeListener(toggleButtonListener);
		ViewHolder.wed.setOnCheckedChangeListener(toggleButtonListener);
		ViewHolder.thu.setOnCheckedChangeListener(toggleButtonListener);
		ViewHolder.fri.setOnCheckedChangeListener(toggleButtonListener);
		ViewHolder.sat.setOnCheckedChangeListener(toggleButtonListener);
		ViewHolder.sun.setOnCheckedChangeListener(toggleButtonListener);

		ViewHolder.datePickerButton = (Button) findViewById(R.id.datePickerButton);
		ViewHolder.datePickerButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Calendar mcurrentTime = Calendar.getInstance();
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;

				mTimePicker = new TimePickerDialog(Planning.this,
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker timePicker,
									int selectedHour, int selectedMinute) {
								ViewHolder.datePickerButton
										.setText(selectedHour + ":"
												+ selectedMinute);
							}
						}, hour, minute, true);
				mTimePicker.setTitle("Select Time");
				mTimePicker.show();
				updateDisplay();

				ViewHolder.time = hour + ":" + minute + "";
				Log.d("time", String.valueOf((ViewHolder.time)));

			}

		});
		loadSavedPreferences();
		updateDisplay();

	}

	public void updateDisplay() {

		ViewHolder.datePickerButton.setText
		
				(new StringBuilder().append(String.valueOf((phour)))
						.append(":").append(String.valueOf((pminute))));

	}

	private void loadSavedPreferences() {
		
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		boolean monState = sharedPreferences.getBoolean("MON", false);
		ViewHolder.mon.setChecked(monState);

		boolean tueState = sharedPreferences.getBoolean("TUE", false);
		ViewHolder.tue.setChecked(tueState);

		boolean wedState = sharedPreferences.getBoolean("WED", false);
		ViewHolder.wed.setChecked(wedState);

		boolean thuState = sharedPreferences.getBoolean("THU", false);
		ViewHolder.thu.setChecked(thuState);

		boolean friState = sharedPreferences.getBoolean("FRI", false);
		ViewHolder.fri.setChecked(friState);

		boolean satState = sharedPreferences.getBoolean("SAT", false);
		ViewHolder.sat.setChecked(satState);

		boolean sunState = sharedPreferences.getBoolean("SUN", false);
		ViewHolder.sun.setChecked(sunState);

		int name = sharedPreferences.getInt("counter", count);

		String savedTime = sharedPreferences.getString("TIME", ViewHolder.time);
		ViewHolder.datePickerButton.setText(savedTime);

		countofdays.setText(name + " " + "DAY(S) SELECTED");

	}

	private void savePreferences(String key, boolean value) {
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();

		editor.putBoolean(key, value);

		editor.commit();

	}

	private void savePreferences(String key, int value) {

		sharedPreferences = PreferenceManager

		.getDefaultSharedPreferences(this);

		Editor editor = sharedPreferences.edit();

		editor.putInt(key, value);

		editor.commit();

	}

	private void savePreferences(String key, String value) {

		sharedPreferences = PreferenceManager

		.getDefaultSharedPreferences(this);

		Editor editor = sharedPreferences.edit();

		editor.putString(key, value);

		editor.commit();

	}

	OnCheckedChangeListener toggleButtonListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (!wasEdited) {
				wasEdited = true;
			}
			if (buttonView.isChecked()) {
				count++;

			} else
				count--;
			countofdays.setText(count + " " + "DAY(S) SELECTED");
			if (ViewHolder.mon.isChecked())
				days = "mon";
			// Log.d(time, "mon");
			if (ViewHolder.tue.isChecked())
				days += " " + " tue";
			if (ViewHolder.wed.isChecked())
				// Log.d(time, "wed");
				days += " " + "wed";
			if (ViewHolder.thu.isChecked())
				// Log.d(time, "thu");
				days += " " + "thu";
			if (ViewHolder.fri.isChecked())
				// Log.d(time,"fri");
				days += " " + "fri";
			if (ViewHolder.sat.isChecked())
				// Log.d(time, "sat");
				days += " " + "sat";
			if (ViewHolder.sun.isChecked())
				// Log.d(time, "sun");
				days += " " + "sun";

			Log.d(time, days);

		}

	};

	class TimePickerFragment extends DialogFragment implements
			TimePickerDialog.OnTimeSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the current time as the default values for the picker
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);

			// Create a new instance of TimePickerDialog and return it
			return new TimePickerDialog(getActivity(), this, hour, minute,
					DateFormat.is24HourFormat(getActivity()));

		}

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// Do something with the time chosen by the user
		}

	}

	protected void onPause() {
		super.onPause();
		if (wasEdited) {
			savePreferences("counter", count);
			savePreferences("MON", ViewHolder.mon.isChecked());
			savePreferences("TUE", ViewHolder.tue.isChecked());
			savePreferences("WED", ViewHolder.wed.isChecked());
			savePreferences("THU", ViewHolder.thu.isChecked());
			savePreferences("FRI", ViewHolder.fri.isChecked());
			savePreferences("SAT", ViewHolder.sat.isChecked());
			savePreferences("SUN", ViewHolder.sun.isChecked());
			savePreferences("TIME", ViewHolder.time);

		}

	}

	public static class ViewHolder {
		static String time;
		static ToggleButton mon;
		static ToggleButton tue;
		static ToggleButton wed;
		static ToggleButton thu;
		static ToggleButton fri;
		static ToggleButton sat;
		static ToggleButton sun;
		static Button datePickerButton;

	}
}