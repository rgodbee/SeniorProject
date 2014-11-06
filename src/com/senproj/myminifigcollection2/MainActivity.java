package com.senproj.myminifigcollection2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.senproj.myminifigcollection.database.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}

		DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this);
		try {

			myDbHelper.createDataBase();
			Toast.makeText(MainActivity.this, "Database creation successful", Toast.LENGTH_SHORT).show();
	        

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}
		        
	}

	/** Called when the user clicks the View Catalog button */
	public void ViewMainCategories(View view) {
		Intent intent = new Intent(getApplicationContext(), MainCategoryListActivity.class);
		startActivity(intent);	    
	}

	/** Called when the user clicks the View Collection button */
	public void ViewCollectionMainCategories(View view) {
		Intent intent = new Intent(getApplicationContext(), MainCategoryListActivity.class);
		startActivity(intent);	    //switch to collection method***************
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
