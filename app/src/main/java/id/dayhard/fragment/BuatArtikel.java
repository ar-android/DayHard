package id.dayhard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.dayhard.R;
import id.dayhard.helper.ArtikelDBHelper;
import id.dayhard.model.ArtikelModel;

/**
 * Created by ocittwo on 8/6/16.
 */
public class BuatArtikel extends Fragment implements View.OnClickListener {

    @BindView(R.id.input_judul)
    EditText input_judul;
    @BindView(R.id.input_content)
    EditText input_content;
    @BindView(R.id.btn_save_artikel)
    Button btn_save_artikel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.buat_artikel, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_save_artikel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save_artikel:
                buatArtikel();
                break;
        }
    }

    private void buatArtikel() {

        ArtikelDBHelper artikelDBHelper = new ArtikelDBHelper(getContext());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String currentDateTime = sdf.format(new Date());

        if (TextUtils.isEmpty(input_judul.getText().toString())){
            input_judul.setError("REQUIRED");
        }else if (TextUtils.isEmpty(input_content.getText().toString())){
            input_content.setError("REQUIRED");
        }else{
            ArtikelModel artikelModel = new ArtikelModel();
            artikelModel.setJudul(input_judul.getText().toString());
            artikelModel.setContent(input_content.getText().toString());
            artikelModel.setDate(currentDateTime);
            artikelModel.setGambar(R.drawable.batman_vs_superman);
            artikelDBHelper.buatArtikel(artikelModel);
            input_judul.getText().clear();
            input_content.getText().clear();
        }
    }


}
