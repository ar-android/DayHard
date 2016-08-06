package id.dayhard.helper;

/**
 * Created by ocittwo on 8/6/16.
 */
public final class HelperSqlite {

    public HelperSqlite() {
    }

    public static abstract class Artikel{
        public static final String TABLE_NAME = "artikel";
        public static final String ARTIKEL_ID = "artikel_id";
        public static final String COLUMN_JUDUL = "judul_artikel";
        public static final String COLUMN_IMAGE = "gambar_artikel";
        public static final String COLUMN_CONTENT = "isi_artikel";
        public static final String COLUMN_DATE = "date_time";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            Artikel.TABLE_NAME + " (" +
            Artikel.ARTIKEL_ID + " INTEGER PRIMARY KEY," +
            Artikel.COLUMN_JUDUL + TEXT_TYPE + COMMA_SEP +
            Artikel.COLUMN_IMAGE + TEXT_TYPE + COMMA_SEP +
            Artikel.COLUMN_CONTENT + TEXT_TYPE + COMMA_SEP +
            Artikel.COLUMN_DATE + TEXT_TYPE +
            " )";
    public static final String SQL_DALETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Artikel.TABLE_NAME;


}
