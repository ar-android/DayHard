package id.dayhard.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.dayhard.model.ArtikelModel;

/**
 * Created by ocittwo on 8/6/16.
 */
public class ArtikelDBHelper extends SQLiteOpenHelper{

    private static final String TAG = "ArtikelDBHelper";

    private HelperSqlite helperSqlite;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Artikel.db";

    public ArtikelDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        helperSqlite = new HelperSqlite();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(helperSqlite.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(helperSqlite.SQL_DALETE_ENTRIES);
        onCreate(db);
    }

    public void onDownGrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Create artikel
     * @param artikelModel
     */
    public void buatArtikel(ArtikelModel artikelModel){
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            values.put(HelperSqlite.Artikel.COLUMN_JUDUL, artikelModel.getJudul());
            values.put(HelperSqlite.Artikel.COLUMN_IMAGE, artikelModel.getGambar());
            values.put(HelperSqlite.Artikel.COLUMN_CONTENT, artikelModel.getContent());
            values.put(HelperSqlite.Artikel.COLUMN_DATE, artikelModel.getDate());

            db.insertOrThrow(HelperSqlite.Artikel.TABLE_NAME, null, values);
            db.setTransactionSuccessful();
            log("Success insert data artikel");
        }catch (Exception e){
            Log.d(TAG, "buatArtikel: Error saat insert database!");
        }finally {
            db.endTransaction();
        }
    }

    /**
     * Get all data artikel
     * @return artikelModelList
     */
    public List<ArtikelModel> getAllArtikel(){
        List<ArtikelModel> artikelModelList = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String QUERY_GET = "SELECT * FROM " +
                HelperSqlite.Artikel.TABLE_NAME;
        Cursor cursor = db.rawQuery(QUERY_GET, null);
        try {
            if (cursor.moveToFirst()){
                do {
                    ArtikelModel artikelModel = new ArtikelModel();
                    artikelModel.setJudul(cursor.getString(
                            cursor.getColumnIndex(
                                    HelperSqlite.Artikel.COLUMN_JUDUL)));
                    artikelModel.setContent(cursor.getString(
                            cursor.getColumnIndex(
                                    HelperSqlite.Artikel.COLUMN_CONTENT)));
                    artikelModel.setDate(cursor.getString(
                            cursor.getColumnIndex(
                                    HelperSqlite.Artikel.COLUMN_DATE)));
                    String gambar = cursor.getString(
                            cursor.getColumnIndex(
                                    HelperSqlite.Artikel.COLUMN_DATE));
                    artikelModel.setGambar(Integer.parseInt(gambar));

                    artikelModelList.add(artikelModel);

                    log(gambar);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            Log.d(TAG, "getAllArtikel: " + e.toString());
        }finally {
            if (cursor != null && !cursor.isClosed()){
                cursor.close();
            }
        }

        return artikelModelList;
    }

    public ArtikelModel getDataArtkel(int id){
        ArtikelModel artikelModel = new ArtikelModel();
        String QUERY = "select * from " +
                HelperSqlite.Artikel.TABLE_NAME + " where artikel_id = " + String.valueOf(id);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(QUERY, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            artikelModel.setJudul(cursor.getString(cursor.getColumnIndex(HelperSqlite.Artikel.COLUMN_JUDUL)));
        }

        return artikelModel;
    }

    /**
     * Logging
     * @param s
     */
    void log(String s){
        Log.d(TAG, "log: " + s);
    }
}
