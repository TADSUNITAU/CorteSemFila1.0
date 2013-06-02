package br.unitau.cortesemfila;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class MarcarHorario2  extends Activity implements OnClickListener {
	String urlfinal;
	WebView verWebView = null;
	final Context context = this;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marcarhorario2);
        
        if(isOnline()){
        
        verWebView  = (WebView)findViewById(R.id.webView0);
        verWebView.getSettings().setJavaScriptEnabled(true);
        verWebView.getSettings().setSupportZoom(true);       
        verWebView.getSettings().setBuiltInZoomControls(true); 
        verWebView.getSettings().setLoadWithOverviewMode(false);
        verWebView.getSettings().setUseWideViewPort(false);        
        //Pega a variavel enviada pela tela anterior e adiciona a url
        Intent telaAnterior = getIntent();
        urlfinal = telaAnterior.getStringExtra("url");    
        verWebView.loadUrl(urlfinal);
        
        //String terminado = "http://cortesemfila.netai.net/foco/index.php?action=display_event*numero";
        
        // Escuta se a pagina terminou de carregar
        verWebView.setWebViewClient(new WebViewClient() {
        	//Testa se a pagina carregada é igual a pagina de confirmar o agendamento
        	   public void onPageFinished(WebView view, String url) {
        	        if(url.equalsIgnoreCase(urlfinal)){
        	        	
        	        } else { //Se não for exibe a mensagem de Agendamento Concluido e volta para o inicio
        	        	/* Alert Dialog Code Start*/             	        	
        	        	CookieManager cookieManager = CookieManager.getInstance();
        	        	cookieManager.removeAllCookie();
        	            AlertDialog.Builder alert = new AlertDialog.Builder(context);
        	            alert.setTitle("Horario agendado"); //Set Alert dialog title here
        	            alert.setMessage("Seu agendamento foi concuido com sucesso!!\n" +
        	            		"\nClique em 'Menu' para escolher mais opções\n" +
        	            		"ou clique em 'Ver' para visualizar a agenda."); //Message here
        	 
        	            alert.setPositiveButton("Menu", new DialogInterface.OnClickListener() {
        	            public void onClick(DialogInterface dialog, int whichButton) {
        	       		 	//Abre tela main
        	            	Intent abreTelaMain = new Intent(context, MainActivity.class);
        	            	finish();
        	       		 	startActivity(abreTelaMain);        	 
        	              }
        	            });
        	 
        	            alert.setNegativeButton("Ver", new DialogInterface.OnClickListener() {
        	              public void onClick(DialogInterface dialog, int whichButton) {
        	            	  //Abre a tela ver.
        	         		 Intent abreTelaVer = new Intent(context, VerHorario.class);
        	         		 finish();
        	                 startActivity(abreTelaVer);
        	              }
        	            });
        	            AlertDialog alertDialog = alert.create();
        	            alertDialog.show();
        	        }
        	        
        	    }
        	});
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