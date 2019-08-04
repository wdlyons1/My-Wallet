package com.finalproject.mywallet;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Customer extends AppCompatActivity {

    EditText myFirstName, myLastName, myType, myAmount;
    Button mySaveButton, myCancelButton;
    Database mydb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        mydb = new Database(this);
        myFirstName = findViewById(R.id.editFirstName);
        myLastName = findViewById(R.id.editLastName);
        myAmount = findViewById(R.id.editAmount);
        myType = findViewById(R.id.editType);
        mySaveButton = findViewById(R.id.buttSave);
        myCancelButton = findViewById(R.id.buttCancel);

    }

    public void onClickCancel(View view) {
        finish();
    }


    public void onClickSave(View view) {

        Database db = new Database(this);
        db.getWritableDatabase();

        boolean isInserted = db.addTransactionDue(myFirstName.getText().toString(), myLastName.getText().toString(), myAmount.getText().toString(), myType.getText().toString());


        if (isInserted == true) {
            Toast.makeText(Add_Customer.this, "Transaction Added", Toast.LENGTH_LONG).show();
            finish();
        }
        else
            Toast.makeText(Add_Customer.this, "Please Try Again", Toast.LENGTH_LONG).show();
    }
}
