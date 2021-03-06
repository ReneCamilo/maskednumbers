package com.example.renecontreras.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.renecontreras.myapplication.utils.Utils;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView tvCardNumberMasked;
    private Button button;
    private Context context;
    private int cardNumberLenght;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        input = findViewById(R.id.input_masked_card_number);
        button = findViewById(R.id.button);
        tvCardNumberMasked = findViewById(R.id.tv_masked_card_number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = input.getText().toString(); // read input text
                //card number validation (range 14 -16)
                if((Utils.isValidPhoneNumber(phoneNumber))){
                    if(input.getText() != null){
                        String inputNumber = input.getText().toString();
                        inputNumber = inputNumber.replaceAll("[\\D]", "");
                        //find repeated number in card number string
                        char repeated = Utils.magicNumber(inputNumber);
                        Log.i("./MainActivity","char repeated: "+repeated);
                        //call maskNumber method to display it on text view
                        tvCardNumberMasked.setText(Utils.maskNumber(inputNumber));
                    }
                }else {
                    Toast toast = Toast.makeText(context, "Phone numbers must be 10-13 digits",
                            Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });
    }
}
