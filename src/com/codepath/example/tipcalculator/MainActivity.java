package com.codepath.example.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public EditText billAmount;
	public TextView tipAmount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		billAmount = (EditText) findViewById(R.id.billAmount);
		tipAmount = (TextView) findViewById(R.id.tipAmount);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calculateTip(View v) {
		String strBillAmount = billAmount.getText().toString();
		Float bill_amount = 0.0f;
		Float tip_amount = 0.0f;
		String calculatedTip = "$0.00";
		if (!strBillAmount.equals("")) {
			try {
				bill_amount = Float.parseFloat(strBillAmount);
			} catch (NumberFormatException e) {
				// display warning if button push happens with invalid amount
				// input
				Toast.makeText(this, "Please enter a valid bill amount",
						Toast.LENGTH_SHORT).show();
			}
			// based on the button push display the respective tip amount
			switch (v.getId()) {
			case R.id.btn10Pctg:
				tip_amount = bill_amount * 0.10f;
				break;
			case R.id.btn15Pctg:
				tip_amount = bill_amount * 0.15f;
				break;
			case R.id.btn20Pctg:
				tip_amount = bill_amount * 0.20f;
				break;
			}
			DecimalFormat df = new DecimalFormat("0.00");
			df.setMaximumFractionDigits(2);
			calculatedTip = "$" + df.format(tip_amount);
		} else {
			// display warning if button push happens with no amount input
			Toast.makeText(this, "Please enter bill amount to calculate tip",
					Toast.LENGTH_SHORT).show();
		}
		tipAmount.setText(calculatedTip);

	}
}
