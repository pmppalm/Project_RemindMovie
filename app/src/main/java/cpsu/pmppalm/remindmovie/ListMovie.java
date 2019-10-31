package cpsu.pmppalm.remindmovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cpsu.pmppalm.remindmovie.adapter.MovielistAdapter;
import cpsu.pmppalm.remindmovie.database.DatabaseMovie;
import cpsu.pmppalm.remindmovie.model.MovieItem;

public class ListMovie extends AppCompatActivity {
    private static final String TAG = ListMovie.class.getName();

    private DatabaseMovie mHelper;
    private SQLiteDatabase mDB;
    private List<MovieItem> mMovieList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        mHelper = new DatabaseMovie(ListMovie.this);
        mDB = mHelper.getWritableDatabase();

        Button add = findViewById(R.id.save_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListMovie.this,AddActivity.class);
                startActivity(i);
            }
        });
    }
}
