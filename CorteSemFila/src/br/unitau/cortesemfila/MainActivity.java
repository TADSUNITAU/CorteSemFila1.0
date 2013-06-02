package br.unitau.cortesemfila;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.content.Context;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu m) {
		super.onCreateOptionsMenu(m);
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate( 
		R.menu.main, m );		
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void marcarHorario(View view){
		//setContentView(R.layout.marcarhorario);
		 final Context context = this;
		 Intent abreTelaMarcar = new Intent(context, MarcarHorario.class);
         startActivity(abreTelaMarcar);   
	}
	
	public void verHorario(View view){
		//setContentView(R.layout.verhorario);
		 final Context context = this;
		 Intent abreTelaVer = new Intent(context, VerHorario.class);
         startActivity(abreTelaVer);
	}
	
	public void ondeEstamos(View view){
		//setContentView(R.layout.ondeestamos);
		 final Context context = this;
		 Intent abreTelaOnde = new Intent(context, OndeEstamos1.class);
         startActivity(abreTelaOnde);
	}

	public void sobre(View view){
		//setContentView(R.layout.sobre);
		 final Context context = this;
		 Intent abreTelaSobre = new Intent(context, Sobre.class);
         startActivity(abreTelaSobre);
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
