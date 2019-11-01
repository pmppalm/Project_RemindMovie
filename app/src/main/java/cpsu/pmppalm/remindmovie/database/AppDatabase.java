package cpsu.pmppalm.remindmovie.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MovieItem.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "movie.db";
    public static AppDatabase mInseance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (mInseance == null) {
            mInseance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).build();
        }
        return mInseance;
    }

    public abstract MovieDao movieDao();
}
