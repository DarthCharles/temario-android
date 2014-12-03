package com.csipro.temarioandroid;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Inicio extends Activity{
Button temario;
Button registro;
private InterstitialAd mInterstitial;
private InterstitialAd mInterstitial1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		
		 
		startInters1();
		startInters();
		temario = (Button) findViewById(R.id.bt_temario);
		temario.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
			     if (mInterstitial.isLoaded()) {
			    	 mInterstitial.show();
                 } else {
                     // Proceed to the next level.
                		Intent i = new Intent(Inicio.this, MainActivity.class);
        				startActivity(i);
                 }
			
				
			}
		});
		
		registro = (Button)  findViewById(R.id.bt_regis);
		registro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			     if (mInterstitial1.isLoaded()) {
			    	 mInterstitial1.show();
                 } else {
                     // Proceed to the next level.
             		Intent i = new Intent(Inicio.this, Registro.class);
    				startActivity(i);
                 }
		
				
				
			}
		});
	}

	private void startInters1(){
		 mInterstitial1 = new InterstitialAd(this);
	        mInterstitial1.setAdUnitId("ca-app-pub-6384779718216490/5644966569");
	        // Create an ad request.
	         AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
	         // Set an AdListener.
	         mInterstitial1.setAdListener(new AdListener() {
	             @Override
	             public void onAdLoaded() {

	             }

	             @Override
	             public void onAdClosed() {
	            	 Intent i = new Intent(Inicio.this, Registro.class);
  				startActivity(i);
	               
	             }
	         });
	         mInterstitial1.loadAd(adRequestBuilder.build());
	}
	
	private void startInters(){
		 mInterstitial = new InterstitialAd(this);
	        mInterstitial.setAdUnitId("ca-app-pub-6384779718216490/7121699769");
	        // Create an ad request.
	         AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
	         // Set an AdListener.
	         mInterstitial.setAdListener(new AdListener() {
	             @Override
	             public void onAdLoaded() {

	             }

	             @Override
	             public void onAdClosed() {
	            	 Intent i = new Intent(Inicio.this, MainActivity.class);
 				startActivity(i);
	               
	             }
	         });
	         mInterstitial.loadAd(adRequestBuilder.build());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
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
}
