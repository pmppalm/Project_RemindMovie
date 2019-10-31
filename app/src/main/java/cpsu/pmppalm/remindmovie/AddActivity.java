package cpsu.pmppalm.remindmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

import cpsu.pmppalm.remindmovie.database.DatabaseMovie;

public class AddActivity extends AppCompatActivity {
    private DatabaseMovie mHelper;
    private SQLiteDatabase mDB;
    private String mLogo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new DatabaseMovie(this);
        mDB = mHelper.getWritableDatabase();

        Button save = findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertMovieItem();
            }
        });
    }

    public void insertMovieItem(){
        EditText nameEditText = findViewById(R.id.name_editText);
        EditText dateEditText = findViewById(R.id.date_editText);
        EditText desEditText = findViewById(R.id.des_editText);

        String name = nameEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String des = desEditText.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put("NAME",name);
        cv.put("DATE",date);
        cv.put("DESCRIPTION",des);


        mDB.insert("TABLE_NAME",null,cv);

        finish();

    }
}
