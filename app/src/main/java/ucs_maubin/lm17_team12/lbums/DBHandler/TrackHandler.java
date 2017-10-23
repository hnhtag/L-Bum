package ucs_maubin.lm17_team12.lbums.DBHandler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ucs_maubin.lm17_team12.lbums.Model.Tracks;

/**
 * Created by nanyu on 10/20/17.
 */

public class TrackHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = new DatabaseName().getDATABASE_NAME();


    private static final String TABLE = "track";

    private static final String TRACK_ID = "track_id";
    private static final String TRACK_NAME = "track_name";
    private static final String TRACK_GENRE = "track_genre";
    private static final String TRACK_ALBUM="track_album";
    private static final String TRACK_ARTIST = "track_artist";

    private static final String FOREIGN_TABLE_1 = "genre";
    private static final String FOREIGN_TABLE_1_ID = "genre_id";
    private static final String FOREIGN_TABLE_2 = "album";
    private static final String FOREIGN_TABLE_2_ID = "album_id";
    private static final String FOREIGN_TABLE_3 = "artist";
    private static final String FOREIGN_TABLE_3_ID = "artist_id";

    public TrackHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_TRACK = "CREATE TABLE " + TABLE  + "("
                + TRACK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + TRACK_NAME + " TEXT, "
                + TRACK_GENRE + " INTEGER ,"
                + TRACK_ALBUM + "INTEGER ,"
                + TRACK_ARTIST + "INTEGER, "
                + "FOREIGN KEY (" + TRACK_GENRE + ") REFERENCES " + FOREIGN_TABLE_1 +"("+FOREIGN_TABLE_1_ID+", "
                + "FOREIGN KEY (" + TRACK_ALBUM + ") REFERENCES " + FOREIGN_TABLE_2 +"("+FOREIGN_TABLE_2_ID+", "
                + "FOREIGN KEY (" + TRACK_ARTIST + ") REFERENCES " + FOREIGN_TABLE_3 +"("+FOREIGN_TABLE_3_ID+")";

        db.execSQL(CREATE_TABLE_TRACK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Create tables again
        onCreate(db);
    }

}
