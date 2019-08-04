package com.finalproject.mywallet;


import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/*   Saves App Users Name in shared preferences   */

public class Preferences extends AppCompatActivity {
    private TextView textView;
    private EditText editText;

    // Constants for Shared Preferences
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NAME = "text";


    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        textView = findViewById(R.id.textViewName);
        editText = findViewById(R.id.editTextName);

        /*Sets up actionbar and upbutton*/
        Toolbar myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Preferences");

        loadData();
        updateViews();
    }

    // Listener for Update Name Button
    public void onClickUpdate(View view){
        textView.setText(editText.getText().toString());
        saveData();

    }

    public void saveData() {
        //Create instance of shared preferences and the editor
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Save data in editText to the editor
        editor.putString(NAME, textView.getText().toString());

        //Save the changes
        editor.apply();

        Toast.makeText(this, "Name Updated", Toast.LENGTH_SHORT).show();
    }

    //Pulls data from shared preferences when activity is opened
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(NAME, "");

    }
    //Updates the views without re-opening the activity
    public void updateViews() {
        textView.setText(text);

    }

}
