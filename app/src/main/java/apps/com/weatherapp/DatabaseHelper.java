package apps.com.weatherapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int database_VERSION = 1;
    private static final String database_NAME = "weatherdb";
    // CurrentWeather Table
    private static final String table_CurrWeather = "Profile";
    private static final String CurrWeather_id = "id";
    private static final String CurrWeather_city = "city";
    private static final String CurrWeather_day = "day";
    private static final String CurrWeather_temperature = "temperature";
    private static final String CurrWeather_description = "description";
    private static final String CurrWeather_tempmax = "tempmax";
    private static final String CurrWeather_tempmin = "tempmin";
    private static final String CurrWeather_humidity = "humidity";
    private static final String CurrWeather_wind = "wind";

    List_Weather list_items = new List_Weather();

    private static final String[] COLUMNS_CurrWeather = {CurrWeather_id, CurrWeather_city, CurrWeather_day,
            CurrWeather_temperature, CurrWeather_description, CurrWeather_tempmax,CurrWeather_tempmin,
            CurrWeather_humidity,CurrWeather_wind};

    public DatabaseHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CurrentWeather (id INTEGER PRIMARY KEY AUTOINCREMENT,city TEXT ,day TEXT," +
                "temperature INTEGER,description TEXT,tempmax INTEGER,tempmin INTEGER, humidity INTEGER, wind INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        this.onCreate(sqLiteDatabase);
    }

    public void createCurrentWeather(List_Weather customer) {
        // get reference of the BookDB database
        SQLiteDatabase db = this.getWritableDatabase();
        // make values to be inserted
        ContentValues values = new ContentValues();
//        values.put(trans_id, transaction.getId());
        values.put(CurrWeather_city, customer.getStringCity());
        values.put(CurrWeather_day, customer.getStringDay());
        values.put(CurrWeather_temperature, customer.getStringTemp());
        values.put(CurrWeather_description, customer.getStringDescription());
        values.put(CurrWeather_tempmax, customer.getStringTempMax());
        values.put(CurrWeather_tempmin, customer.getStringTempMin());
        values.put(CurrWeather_humidity, customer.getStringHumidity());
        values.put(CurrWeather_wind, customer.getStringWind());
        // insert book
        db.insert(table_CurrWeather, null, values);
        // close database transaction
        db.close();
    }
}
