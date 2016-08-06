package id.dayhard.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import id.dayhard.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_lv;
    private Button btn_rv;
    private Button btn_shrf;
    private Button btn_sql;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;

        btn_lv = (Button) findViewById(R.id.btn_lv);
        btn_rv = (Button) findViewById(R.id.btn_rv);
        btn_shrf = (Button) findViewById(R.id.btn_shrf);
        btn_sql = (Button) findViewById(R.id.btn_sql);

        btn_lv.setOnClickListener(this);
        btn_rv.setOnClickListener(this);
        btn_shrf.setOnClickListener(this);
        btn_sql.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lv:
                startActivity(new Intent(context, LvActivity.class));
                break;
            case R.id.btn_rv:
                startActivity(new Intent(context, RvActivity.class));
                break;
            case R.id.btn_shrf:
                Intent intent = new Intent(context, ShrfActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sql:
                startActivity(new Intent(context, DataActivity.class));
                break;
        }
    }
}
