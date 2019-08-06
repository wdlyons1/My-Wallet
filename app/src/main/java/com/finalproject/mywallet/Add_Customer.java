package com.finalproject.mywallet;


import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Customer extends AppCompatActivity {

    EditText myFirstName, myLastName, myType, myAmount;
    Button mySaveButton, myCancelButton;
    Button view;

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
        view = findViewById(R.id.view);
        viewItem();

    }

    public void viewItem()
    {
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor result = mydb.getAllRecipesOwe();
                        if (result.getCount() == 0) {
                            //show message
                            showMewssage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (result.moveToNext()) {
                            buffer.append("first name: " + result.getString(1) + "\n");
                            buffer.append("Last name: " + result.getString(2) + "\n");
                            buffer.append("amount: " + result.getString(3) + "\n");
                            buffer.append("transaction type: " + result.getString(4) + "\n\n");
                        }
                        showMewssage("items", buffer.toString());
                    }

                }
        );

    }

    public void showMewssage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
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
            final MediaPlayer bells = MediaPlayer.create(this, R.raw.bells);
            bells.start();
            finish();
        }
        else
            Toast.makeText(Add_Customer.this, "Please Try Again", Toast.LENGTH_LONG).show();
    }
}
