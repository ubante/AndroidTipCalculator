package com.ubante.assignments.tipcalculator;

//import com.ubante.example.myfirstapp.R;
import com.ubante.assignments.tipcalculator.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Locale;

public class TipCalculatorActivity extends Activity {
	public EditText etInputBillTotal;
	public TextView tvOutputTip;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		etInputBillTotal = (EditText) findViewById(R.id.etInputBillTotal);
		tvOutputTip = (TextView) findViewById(R.id.tvOutputTip);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	boolean isNumeric (String s) {
	/*
		If user inputs something other than a number, makeAnswer throws an NFE and the emulator crashes.
	*/
		try {
			Double.parseDouble(s);
		}
		catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	String makeAnswer(double percentage) {
		//Editable totalText = etInputBillTotal.getText();
		//String total = totalText.toString();
		String total = etInputBillTotal.getText().toString();
		
		// Check if the user provided input is a number
		if ( isNumeric(total) ) {
			double dtip = Double.parseDouble(total) * percentage;
			String tip = String.format(Locale.getDefault(), "Tip is: $%.2f", dtip);
			return tip;
		} else {
			return "Please enter a number.";
		}
	}

	public void onSubmit(View v) {
	// Some of this casting has to go1
		double tipPercent = Double.parseDouble((String) v.getTag());
		String tip = makeAnswer(tipPercent);
		tvOutputTip.setText(tip);
	}

	public void onSubmit1(View v) {
		String total = etInputBillTotal.getText().toString();
		double dtip = Double.parseDouble(total) * 0.15;
		String tip = String.format(Locale.getDefault(), "Tip is:    $%.2f", dtip);
		tvOutputTip.setText(tip);
	}
}
