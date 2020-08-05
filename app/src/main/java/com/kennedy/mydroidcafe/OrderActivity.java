package com.kennedy.mydroidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent displayIntent = getIntent();
        String displayOrder = displayIntent.getStringExtra(MainActivity.extra_order_Key);
        TextView showOrder = findViewById(R.id.orderDisplay);
        showOrder.setText(displayOrder);


    }

    public void onRadio_Button_Clicked(View view) {
        //create a boolean variable to determine checked rbutton
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radioMpesa:
                if(checked)
                displayToast(getString(R.string.mpesa));
                break;
            case R.id.radioPaypal:
                if (checked)
                    displayToast(getString(R.string.paypal));
                break;
            case R.id.radioCashOnDelivery:
                if (checked)
                    displayToast(getString(R.string.cash_on_delivery));
                default:
                    //do this
                    break;


        }


    }
    //display option selected
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }
}
