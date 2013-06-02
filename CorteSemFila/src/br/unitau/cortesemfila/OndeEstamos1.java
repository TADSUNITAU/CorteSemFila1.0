package br.unitau.cortesemfila;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class OndeEstamos1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onde_estamos1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.onde_estamos1, menu);
		return true;
	}
	
	public void mapa(View view){
		//setContentView(R.layout.verhorario);
		 final Context context = this;
		 Intent abreTelaMapa = new Intent(context, OndeEstamos.class);
         startActivity(abreTelaMapa);
	}
	
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (item.getItemId() == R.id.item1) {
			Intent dial = new Intent();
			dial.setAction("android.intent.action.DIAL");
			dial.setData(Uri.parse("tel:1230256488"));
			startActivity(dial); 			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
