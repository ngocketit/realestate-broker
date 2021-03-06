package com.ngocketit.realestatebroker.database.table;

import android.database.sqlite.SQLiteDatabase;

import com.ngocketit.realestatebroker.database.TableColumn;

import java.util.HashMap;

public class ItemVocabularyTable extends  BaseTable {
    public static final String TABLE_NAME = "items_vocabularies";

    public static final String TABLE_CREATE = "CREATE TABLE "
            + TABLE_NAME
            + "("
            + BASE_FIELDS_CREATE
            + TableColumn.ITEM_ID + " integer not null,"
            + TableColumn.TAXONOMY_ID + " integer not null,"
            + TableColumn.ITEM_TYPE + " text not null"
            + ")";

    public static HashMap<String, String> getProjectionMap() {
        HashMap<String, String> map = BaseTable.getProjectionMap();

        map.put(TableColumn.ITEM_ID, TableColumn.ITEM_ID);
        map.put(TableColumn.TAXONOMY_ID, TableColumn.TAXONOMY_ID);
        map.put(TableColumn.ITEM_TYPE, TableColumn.ITEM_TYPE);

        return map;
    }

    public static void onCreate(SQLiteDatabase db) {
        BaseTable.onCreate(db);
        db.execSQL(TABLE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        BaseTable.onUpgrade(db, oldVersion, newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
