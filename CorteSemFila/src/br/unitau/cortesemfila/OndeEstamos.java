package br.unitau.cortesemfila;

import br.unitau.cortesemfila.R;
import android.webkit.WebView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;

@SuppressLint("SetJavaScriptEnabled")

public class OndeEstamos extends Activity implements OnClickListener {
	
	WebView verWebView = null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ondeestamos);
        if(isOnline()){
        verWebView  = (WebView)findViewById(R.id.webView3);
        verWebView.getSettings().setJavaScriptEnabled(true);
        verWebView.getSettings().setSupportZoom(true);       
        verWebView.getSettings().setBuiltInZoomControls(true); 
        verWebView.getSettings().setLoadWithOverviewMode(false);
        verWebView.getSettings().setUseWideViewPort(true);
        verWebView.loadUrl("https://maps.google.com.br/maps?q=-23.036148,-45.586631&hl=pt&geocode=+&t=m&z=16");
        } else {
        	Toast.makeText(getApplicationContext(), "Erro: Sem conexão com internet", Toast.LENGTH_SHORT).show();
        	finish();
        }
	}
	
	@Override
	public void onClick(android.view.View v) {
		// TODO Auto-generated method stub
		
	}

	//Testa conexão
	public boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}
}
