package com.kennedy.mydroidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private String myOrderMessage;
    public static final String extra_order_Key = "my order is here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implement explicit intent for opening orderactivity.
                Intent orderIntent = new Intent(MainActivity.this,OrderActivity.class);
                orderIntent.putExtra(extra_order_Key,myOrderMessage);
                startActivity(orderIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     //   if (id == R.id.action_settings) {
      //      return true;
     //   }
//Create a switch to handle item selected
        switch (item.getItemId()){
            case R.id.action_order:
                Intent orderIntent = new Intent(MainActivity.this,OrderActivity.class);
                orderIntent.putExtra(extra_order_Key,myOrderMessage);
                startActivity(orderIntent);
                return true;
            case R.id.action_call_us:
                //implicit intent that calls your number
                Uri uriCall = Uri.parse("tel:0702038679");
                Intent myIntentCall = new Intent(Intent.ACTION_DIAL,uriCall);
                startActivity(myIntentCall);

                return true;

                //impliment location and webpage.
            case R.id.action_location:
                Uri uriLocation = Uri.parse("geo:-1.3697163,36.9366873");
                Intent intentlocation = new Intent(Intent.ACTION_VIEW,uriLocation);
                intentlocation.setPackage("com.google.android.apps.maps");
                startActivity(intentlocation);

                return true;



        }
        return super.onOptionsItemSelected(item);
    }
//method for displaying toast messages

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }


    public void showDougnutMessage(View view) {
       // displayToast(getString(R.string.doughnut_order));
        myOrderMessage = getString(R.string.doughnut_order);
        displayToast(myOrderMessage);
    }

    public void showFroyoMessage(View view) {
        //displayToast(getString(R.string.froyo_order));
        myOrderMessage = getString(R.string.froyo_order);
        displayToast(myOrderMessage);

    }

    public void showIcecreamMessage(View view) {
        //displayToast(getString(R.string.iceCream_order));
        myOrderMessage =getString(R.string.iceCream_order);
        displayToast(myOrderMessage);
    }
}
