package id.dayhard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import id.dayhard.R;
import id.dayhard.adapter.RvAdapter;
import id.dayhard.model.Film;
import id.dayhard.viewholder.FilmViewHolder;

public class RvActivity extends AppCompatActivity {

    private RecyclerView rv_test;
    private ArrayList<Film> films;
    private RvAdapter<Film, FilmViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        rv_test = (RecyclerView) findViewById(R.id.rv_test);
        rv_test.setLayoutManager(new GridLayoutManager(this, 2));

        films = new ArrayList<>();
        films.add(new Film("Deadpool", R.drawable.deadpool, "New Box Ofice moview from hollywood"));
        films.add(new Film("Zootopia", R.drawable.zootopia, "New Box Ofice moview from hollywood"));
        films.add(new Film("Captain America and Civil War", R.drawable.captain_america_civil_war, "New Box Ofice moview from hollywood"));
        films.add(new Film("Ghostbusters", R.drawable.ghostbusters, "New Box Ofice moview from hollywood"));

        rv_test.setAdapter(new RvAdapter<Film, FilmViewHolder>(
                R.layout.list_rv, FilmViewHolder.class, Film.class, films) {

            @Override
            protected void bindViewHolder(FilmViewHolder holder,
                                          final Film model, int position) {
                holder.bindView(model, position);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RvActivity.this, model.name, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

}
