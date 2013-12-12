package com.example.myfirstandriodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstandriodapp.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// Handle presses on the action bar items
		switch (item.getItemId()) {
			case R.id.action_search:
				openSearch();
				return true;
			case R.id.action_settings:
				openSettings();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	private void openSearch(){
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		String message = "This is the search view";
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	private void openSettings(){
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		String message = "This is the settings menu";
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view){
		// Open new window in response to button press
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText)findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

}
