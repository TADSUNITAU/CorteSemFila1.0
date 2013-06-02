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
public class VerHorario extends Activity implements OnClickListener {
	
	WebView verWebView = null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verhorario);
        if(isOnline()){
        verWebView  = (WebView)findViewById(R.id.webView1);
        verWebView.getSettings().setJavaScriptEnabled(true);
        verWebView.getSettings().setSupportZoom(true);       
        verWebView.getSettings().setBuiltInZoomControls(true); 
        verWebView.getSettings().setLoadWithOverviewMode(false);
        verWebView.getSettings().setUseWideViewPort(true);
        verWebView.loadUrl("http://cortesemfila.netai.net/foco/");
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