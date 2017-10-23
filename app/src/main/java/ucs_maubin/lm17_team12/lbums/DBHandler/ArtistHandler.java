package ucs_maubin.lm17_team12.lbums.DBHandler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nanyu on 10/20/17.
 */

public class ArtistHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = new DatabaseName().getDATABASE_NAME();
    private static final String TABLE = "artist";

    private static final String ARTIST_ID = "artist_id";
    private static final String ARTIST_NAME = "artist_name";
    private static final String ARTIST_COVER = "artist_cover";
    public ArtistHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_ARTIST= "CREATE TABLE " + TABLE  + "("
                + ARTIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + ARTIST_NAME + " TEXT, "
                + ARTIST_COVER + " TEXT )";

        db.execSQL(CREATE_TABLE_ARTIST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Create tables again
        onCreate(db);
    }
}
