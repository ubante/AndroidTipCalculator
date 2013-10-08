package com.ubante.assignments.tipcalculator;

//import com.ubante.example.myfirstapp.R;
import com.ubante.assignments.tipcalculator.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

	String makeAnswer(double percentage) {
		String total = etInputBillTotal.getText().toString();
		double dtip = Double.parseDouble(total) * percentage;
		String tip = String.format("Tip is: $%.2f", dtip);
		return tip;
	}
	
	public void onSubmit10(View v) {
		String tip = makeAnswer(0.10);
		tvOutputTip.setText(tip);
	}

	public void onSubmit15(View v) {
		String tip = makeAnswer(0.15);
		tvOutputTip.setText(tip);
	}

	public void onSubmit20(View v) {
		String tip = makeAnswer(0.20);
		tvOutputTip.setText(tip);
	}

	public void onSubmit1(View v) {
		String total = etInputBillTotal.getText().toString();
		double dtip = Double.parseDouble(total) * 0.15;
		String tip = String.format("Tip is:    $%.2f", dtip);
		//String tip = String.format("Tip is:");
		tvOutputTip.setText(tip);
	}
}
