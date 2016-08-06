package id.dayhard.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.dayhard.R;

public class DashboardActivity extends AppCompatActivity {

    private Button btn_logout;
    private SharedPreferences shrf;
    private String myPref = "Account";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_logout = (Button) findViewById(R.id.btn_logout);
        shrf = getSharedPreferences(myPref, MODE_PRIVATE);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteShrf();
            }
        });

    }

    /**
     * Delete data from shared preferences
     */
    private void deleteShrf() {
        SharedPreferences.Editor editor = shrf.edit();
        editor.remove("email");
        editor.remove("password");
        editor.commit();
        startActivity(new Intent(this, ShrfActivity.class));
        finish();
    }
}
