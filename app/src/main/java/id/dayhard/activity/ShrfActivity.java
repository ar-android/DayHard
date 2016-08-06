package id.dayhard.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.dayhard.R;

public class ShrfActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input_email;
    private EditText input_password;
    private Button btn_login;
    private SharedPreferences shrf;
    private String myPref = "Account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrf);

        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        shrf = getSharedPreferences(myPref, Context.MODE_PRIVATE);

    }

    /**
     * Do login to RvActvity
     */
    void doLogin() {
        String str_email = "mail@gmail.com";
        String str_password = "qweasd123";

        if(str_email.equals(input_email.getText().toString())){
            if (str_password.equals(input_password.getText().toString())){
                log("Logged in!");
                savePref();
                startActivity(new Intent(this, DashboardActivity.class));
                finish();
            }else{
                Toast.makeText(ShrfActivity.this,
                        "Login failed password is incorrect!",
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(ShrfActivity.this,
                    "Login failed email incorrect!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Save to shared preferences
     */
    private void savePref() {
        SharedPreferences.Editor editor = shrf.edit();
        editor.putString("email", input_email.getText().toString());
        editor.putString("password", input_password.getText().toString());
        editor.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        cekCached();
    }

    /**
     * Check if user have been logged in
     */
    private void cekCached() {
        String  email = shrf.getString("email", "");
        log(email);
        if (email.length() > 10){
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                doLogin();
                break;
        }
    }

    private static final String TAG = "ShrfActivity";

    /**
     * Logging for debuging
     * @param s
     */
    void log(String s){
        Log.d(TAG, "log: " + s);
    }
}
