package com.example.sweetpastry1;

import android.content.ClipData;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Basket extends AppCompatActivity {
    final String TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Button button = findViewById(R.id.button);
        final Spinner spinner1 =  findViewById(R.id.spinner1);

        final ArrayAdapter<CharSequence> adapter_cakes = ArrayAdapter.createFromResource(this, R.array.cakes, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter_cupcakes = ArrayAdapter.createFromResource(this, R.array.cupcakes, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter_donuts = ArrayAdapter.createFromResource(this, R.array.donats, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter_pastries = ArrayAdapter.createFromResource(this, R.array.pastrys, android.R.layout.simple_spinner_item);

        adapter_cakes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_cupcakes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_donuts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_pastries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter_type = ArrayAdapter.createFromResource(this, R.array.bakes, android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter_type);
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "on item selected" + spinner1.getSelectedItem());
                Spinner spinner1 = findViewById(R.id.spinner1);
                Spinner spinner2 = findViewById(R.id.spinner2);
                switch (position) {
                    case 0:
                    spinner2.setAdapter(adapter_cakes);
                    break;
                    case 1:
                    spinner2.setAdapter(adapter_donuts);
                    break;
                    case 2:
                    spinner2.setAdapter(adapter_cupcakes);
                    break;
                    case 3:
                    spinner2.setAdapter(adapter_pastries);
                    break;
                }
                    }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.editText0);
                EditText surname = findViewById(R.id.editText1);
                EditText phone = findViewById(R.id.editText2);
                EditText address = findViewById(R.id.editText3);
                String s = "";
                s += name.getText();
                s += surname.getText();;
                s += phone.getText();
                s += address.getText();
            sendSMS("89244623952", s);
            }
        };
        button.setOnClickListener(onClickListener);


    }
    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}