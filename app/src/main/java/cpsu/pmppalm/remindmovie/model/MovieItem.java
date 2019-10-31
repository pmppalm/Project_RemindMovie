package cpsu.pmppalm.remindmovie.model;


import java.util.Locale;

public class MovieItem {
    public final long id;
    public final String name;
    public final String date;
    public final String description;
    public int imageRes;

    public MovieItem(long id, String name, String date, String description,int imageRes) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.imageRes = imageRes;
    }
    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this.id,
                this.name,
                this.description
        );
        return msg;
    }

}
