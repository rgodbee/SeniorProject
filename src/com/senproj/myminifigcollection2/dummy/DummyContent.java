package com.senproj.myminifigcollection2.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.senproj.myminifigcollection.database.DatabaseHelper;
import com.senproj.myminifigcollection2.MainCategoryListFragment;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	/*static {
		// Add 3 sample items.
		addItem(new DummyItem("1", "Item 1"));
		addItem(new DummyItem("2", "Item 2"));
		addItem(new DummyItem("3", "Item 3"));
	}*/

	public static void setContext(Context c) {
		DatabaseHelper myDbHelper = new DatabaseHelper(c); // SQLiteOpenHelper + SQLiteDatabase manager
		try {   //used this for testing	           
			myDbHelper.openDataBase();
		}catch(SQLException sqle){
			throw sqle;
		}
		Cursor cur = myDbHelper.query("tblMainCategories", null, null, null, null,null, null); // database query
		if (cur.moveToFirst()) {
			do {
				DummyItem item = new DummyItem(cur.getString(0), cur.getString(2));
				addItem(item);
			} while (cur.moveToNext());
		}
	}


	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String content;

		public DummyItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
