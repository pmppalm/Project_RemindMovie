package cpsu.pmppalm.remindmovie.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    List<MovieItem> getAll();

    @Insert
    void insert(MovieItem movieItem);
}
