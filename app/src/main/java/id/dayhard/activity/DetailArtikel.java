package id.dayhard.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import id.dayhard.R;
import id.dayhard.fragment.BuatArtikel;
import id.dayhard.helper.ArtikelDBHelper;
import id.dayhard.helper.Constans;
import id.dayhard.model.ArtikelModel;

public class DetailArtikel extends AppCompatActivity {

    private String type_artikel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);

        type_artikel = getIntent().getStringExtra(Constans.TYPE_ARTIKEL);

        setType_artikel(type_artikel);
    }

    /**
     * Set fragment by type artikel
     * @param type
     */
    private void setType_artikel(String type){
        Fragment fragment = null;
        if (type.equals(Constans.CREATE_ARTIKEL)){
            fragment = new BuatArtikel();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }else if (type.equals(Constans.READ_ARTIKEL)){
            getArtikel();
        }

//        if (fragment != null)
    }

    private void getArtikel() {
        ArtikelDBHelper artikelDBHelper = new ArtikelDBHelper(this);
        List<ArtikelModel> data = artikelDBHelper.getAllArtikel();
        for (int i = 0; i < data.size(); i++) {
            log(data.get(i).getJudul());
            log(data.get(i).getContent());
        }
        log("get artikel has executed!");
//        ArtikelModel data = artikelDBHelper.getDataArtkel(0);
//        log(data.getJudul());
    }

    private static final String TAG = "DetailArtikel";
    void log(String s){
        Log.d(TAG, "log: " + s);
    }
}
