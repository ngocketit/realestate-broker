package com.ngocketit.realestatebroker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ngocketit.realestatebroker.database.table.AppointmentReminderTable;
import com.ngocketit.realestatebroker.database.table.AppointmentTable;
import com.ngocketit.realestatebroker.database.table.CustomerTable;
import com.ngocketit.realestatebroker.database.table.ItemAttachmentTable;
import com.ngocketit.realestatebroker.database.table.ItemAttributeTable;
import com.ngocketit.realestatebroker.database.table.ItemVocabularyTable;
import com.ngocketit.realestatebroker.database.table.LeadTable;
import com.ngocketit.realestatebroker.database.table.PropertyTable;
import com.ngocketit.realestatebroker.database.table.TaxonomyTable;
import com.ngocketit.realestatebroker.database.table.UserAccountTable;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "brokermate";
	private static final int DATABASE_VERSION = 1;
	private static DatabaseHelper sInstance = null;
	
	public static DatabaseHelper getInstance(Context ctx) {
		if (sInstance == null) {
			sInstance = new DatabaseHelper(ctx);
		}
		return sInstance;
	}
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		UserAccountTable.onCreate(database);
		CustomerTable.onCreate(database);
		PropertyTable.onCreate(database);

        AppointmentTable.onCreate(database);
        ItemAttachmentTable.onCreate(database);
        ItemAttributeTable.onCreate(database);
        ItemVocabularyTable.onCreate(database);
        LeadTable.onCreate(database);
        TaxonomyTable.onCreate(database);
        AppointmentReminderTable.onCreate(database);
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		UserAccountTable.onUpgrade(database, oldVersion, newVersion);
		CustomerTable.onUpgrade(database, oldVersion, newVersion);
		PropertyTable.onUpgrade(database, oldVersion, newVersion);

        AppointmentTable.onUpgrade(database, oldVersion, newVersion);
        ItemAttributeTable.onUpgrade(database, oldVersion, newVersion);
        ItemAttachmentTable.onUpgrade(database, oldVersion, newVersion);
        ItemVocabularyTable.onUpgrade(database, oldVersion, newVersion);
        LeadTable.onUpgrade(database, oldVersion, newVersion);
        TaxonomyTable.onUpgrade(database, oldVersion, newVersion);
        AppointmentReminderTable.onUpgrade(database, oldVersion, newVersion);
	}
}
