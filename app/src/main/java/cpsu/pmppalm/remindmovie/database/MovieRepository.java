package cpsu.pmppalm.remindmovie.database;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class MovieRepository {

    private Context mContext;

    public MovieRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getMovie(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertMovie(MovieItem item, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    public interface Callback {
        void onGetMovie(List<MovieItem> itemList);
    }

    public interface InsertCallback {
        void onInsertSuccess();
    }

    private static class GetTask extends AsyncTask<Void, Void, List<MovieItem>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<MovieItem> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<MovieItem> itemList = db.movieDao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<MovieItem> movieItemList) {
            super.onPostExecute(movieItemList);

            mCallback.onGetMovie(movieItemList);
        }
    }

    private static class InsertTask extends AsyncTask<MovieItem, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(MovieItem... movieItems) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.movieDao().insert(movieItems[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    } // ปิด InsertTask
}