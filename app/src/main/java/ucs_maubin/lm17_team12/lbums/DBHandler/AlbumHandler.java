package ucs_maubin.lm17_team12.lbums.DBHandler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nanyu on 10/20/17.
 */

public class AlbumHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = new DatabaseName().getDATABASE_NAME();

    private static final String TABLE = "album";

    private static final String ALBUM_ID = "album_id";
    private static final String ALBUM_NAME = "album_name";
    private static final String ALBUM_TRACKS="album_tracks";
    private static final String ALBUM_COVER = "album_cover";


    public AlbumHandler(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_ALBUM = "CREATE TABLE " + TABLE  + "("
                + ALBUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + ALBUM_NAME + " TEXT, "
                +ALBUM_TRACKS+" INTEGER, "
                + ALBUM_COVER + " TEXT )";

        db.execSQL(CREATE_TABLE_ALBUM);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Create tables again
        onCreate(db);
    }
}
