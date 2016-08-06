package id.dayhard.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dayhard.R;
import id.dayhard.helper.Constans;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.create_artikel)
    Button create_artikel;
    @BindView(R.id.edit_artikel)
    Button edit_artikel;
    @BindView(R.id.delete_artikel)
    Button delete_artikel;
    @BindView(R.id.read_artikel)
    Button read_artikel;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ButterKnife.bind(this);
        context = this;

        create_artikel.setOnClickListener(this);
        edit_artikel.setOnClickListener(this);
        delete_artikel.setOnClickListener(this);
        read_artikel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_artikel:
                Intent intentCreate = new Intent(context, DetailArtikel.class);
                intentCreate.putExtra(Constans.TYPE_ARTIKEL, Constans.CREATE_ARTIKEL);
                startActivity(intentCreate);
                break;
            case R.id.read_artikel:
                Intent intentReadArtikel = new Intent(context, DetailArtikel.class);
                intentReadArtikel.putExtra(Constans.TYPE_ARTIKEL, Constans.READ_ARTIKEL);
                startActivity(intentReadArtikel);
                break;
        }
    }
}
