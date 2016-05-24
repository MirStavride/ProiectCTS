package com.example.sandumihai.discovertheworld;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "aboutCountry2.db";
    private static final String TABLE_NAME = "informatii";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_KEY = "name";
    private static final String COLUMN_INFO ="about";
    SQLiteDatabase db;



    //constructor
    public DataBaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + " (id integer primary key autoincrement, name text, about text)");
        String insertraw1 = "insert into informatii (name,about) values (' Romania','Romania is in southeast Europe and is slightly smaller than Oregon. The Carpathian Mountains divide Romania s upper half from north to south and connect near the center of the country with the Transylvanian Alps, running east and west. North and west of these ranges lies the Transylvanian plateau, and to the south and east are the plains of Moldavia and Walachia. In its last 306 km, the Danube River flows through Romania only. It enters the Black Sea in northern Dobruja, just south of the border with Ukraine.')";
        db.execSQL(insertraw1);
        String insertraw2 = "insert into informatii (name,about) values (' United States','The president is elected for a four-year term and may be reelected only once. The bicameral Congress consists of the 100-member Senate, elected to a six-year term with one-third of the seats becoming vacant every two years, and the 435-member House of Representatives, elected every two years. The minimum voting age is 18.')";
        db.execSQL(insertraw2);
        String insertraw3 = "insert into informatii (name,about) values (' Spain', 'Spain occupies 85% of the Iberian Peninsula, which it shares with Portugal, in southwest Europe. Africa is less than 16 km south at the Strait of Gibraltar. A broad central plateau slopes to the south and east, crossed by a series of mountain ranges and river valleys. Principal rivers are the Ebro in the northeast, the Tajo in the central region, and the Guadalquivir in the south. Off Spain s east coast in the Mediterranean are the Balearic Islands 1,936 sq mi; 5,014 sq km, the largest of which is Majorca. Sixty mi 97 km west of Africa are the Canary Islands 2,808 sq mi; 7,273 sq km.')";
        db.execSQL(insertraw3);
        String insertraw4 = "insert into informatii (name,about) values (' Andorra', 'Andorra is nestled high in the Pyrénées Mountains on the French-Spanish border.')";
        db.execSQL(insertraw4);
        String insertraw5 = "insert into informatii (name,about) values (' Armenia', 'Armenia is located in the southern Caucasus and is the smallest of the former Soviet republics. It is bounded by Georgia on the north, Azerbaijan on the east, Iran on the south, and Turkey on the west. Contemporary Armenia is a fraction of the size of ancient Armenia. A land of rugged mountains and extinct volcanoes, its highest point is Mount Aragats, 13,435 ft (4,095 m).')";
        db.execSQL(insertraw5);
        String insertraw6 = "insert into informatii (name,about) values (' Austria', 'Slightly smaller than Maine, Austria includes much of the mountainous territory of the eastern Alps (about 75% of the area). The country contains many snowfields, glaciers, and snowcapped peaks, the highest being the Grossglockner (12,530 ft; 3,819 m). The Danube is the principal river. Forests and woodlands cover about 40% of the land.')";
        db.execSQL(insertraw6);
        String insertraw7 = "insert into informatii (name,about) values (' Belarus', 'Much of Belarus (formerly the Belorussian Soviet Socialist Republic of the USSR, and then Byelorussia) is a hilly lowland with forests, swamps, and numerous rivers and lakes. There are wide rivers emptying into the Baltic and Black seas. Its forests cover over one-third of the land and its peat marshes are a valuable natural resource. The largest lake is Narach, 31 sq mi (79.6 sq km).')";
        db.execSQL(insertraw7);
        this.db = db;
    }



    //cauta daca tara ceruta exista in baza de date, iar daca exista se retin informatiile intr-o variabila
    //--------------------------------------------------SEARCHING COUNTRY-------------------------------------------------------
    public String searchCountry(String Countryname) {
        db = this.getReadableDatabase();
        String query = "select name, about from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(Countryname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

         db.execSQL("drop table if exists " +TABLE_NAME);
         this.onCreate(db);
    }

}
