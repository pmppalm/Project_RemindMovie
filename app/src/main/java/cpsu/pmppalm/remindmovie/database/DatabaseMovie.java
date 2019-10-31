package cpsu.pmppalm.remindmovie.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;


public class DatabaseMovie extends SQLiteOpenHelper {

    private static final String DB_NAME = "remind";
    private static final int DB_VERSION = 5;


    public static final String TABLE_NAME = "movie";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DATE = "date";
    public static final String DESCRIPTION = "description";

    private static final String SQL_CREATE_TABLE_MOVIE
            = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT,"
            + DATE + " DATETIME,"
            + DESCRIPTION + " TEXT "
            + ")";


    public DatabaseMovie(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_MOVIE);

        ContentValues cv = new ContentValues();
        cv.put(NAME, "Oh My Venus");
        cv.put(DATE, "8/11/2019");
        cv.put(DESCRIPTION, "นางเอกพยายามที่จะผอม จึงไปตามตื้อให้พระเอกช่วยเป็นเทรนเนอร์");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(NAME, "13 Reason Why");
        cv.put(DATE, "2/11/2019");
        cv.put(DESCRIPTION, "เคย์ได้ฟังเทปจากฮันน่าที่ตายไปอย่างปริศนา");
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
