package cpsu.pmppalm.remindmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cpsu.pmppalm.remindmovie.adapter.MovieRecyclerViewAdapter;
import cpsu.pmppalm.remindmovie.database.MovieItem;
import cpsu.pmppalm.remindmovie.database.MovieRepository;


public class ListMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListMovie.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        reloadData();
    }

    private void reloadData() {
        MovieRepository repository = new MovieRepository(ListMovie.this);

        repository.getMovie(new MovieRepository.Callback() {
            @Override
            public void onGetMovie(List<MovieItem> itemList) {
                RecyclerView recyclerView = findViewById(R.id.movie_recycler_view);
                MovieRecyclerViewAdapter adapter = new MovieRecyclerViewAdapter(ListMovie.this,R.layout.item_movie,itemList);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListMovie.this));
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
