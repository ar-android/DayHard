package id.dayhard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import id.dayhard.R;
import id.dayhard.adapter.PeopleAdapter;
import id.dayhard.model.PeopleModel;

public class LvActivity extends AppCompatActivity {

    private ListView lv_test;
    private ArrayList<PeopleModel> data;

//    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);

        lv_test = (ListView) findViewById(R.id.lv_test);

//        setList();
        setCustomListview();

    }
//
//    void setList(){
//
//        final String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2" };
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, values);
//        lv_test.setAdapter(adapter);
//
//        lv_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent,
//                                    View view, int position, long id) {
//                Toast.makeText(LvActivity.this,
//                        values[position], Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


    void setCustomListview(){

        data = new ArrayList<>();

        data.add(new PeopleModel(
                R.drawable.batman_vs_superman,
                "Batman Superman",
                "Sub title superman",
                "New Howllywod Film",
                "12 Mei 16"));
        data.add(new PeopleModel(
                R.drawable.batman_vs_superman,
                "Batman Superman",
                "Sub title superman",
                "New Howllywod Film",
                "12 Mei 16"));
        data.add(new PeopleModel(
                R.drawable.batman_vs_superman,
                "Batman Superman",
                "Sub title superman",
                "New Howllywod Film",
                "12 Mei 16"));
        data.add(new PeopleModel(
                R.drawable.batman_vs_superman,
                "Batman Superman",
                "Sub title superman",
                "New Howllywod Film",
                "12 Mei 16"));
        data.add(new PeopleModel(
                R.drawable.batman_vs_superman,
                "Batman Superman",
                "Sub title superman",
                "New Howllywod Film",
                "12 Mei 16"));

        PeopleAdapter adapter = new PeopleAdapter(this, data);
        lv_test.setAdapter(adapter);

    }
}
