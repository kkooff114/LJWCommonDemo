package com.loujiwei.ADemo.function;

import android.os.AsyncTask;
import android.os.Bundle;

import com.loujiwei.ADemo.R;
import com.loujiwei.common.activity.LJWBaseActivity;
import com.loujiwei.common.customfunction.CommonLog;

import android.annotation.SuppressLint;
import android.content.Context;  
import android.content.pm.ActivityInfo;  
import android.location.Location;  
import android.location.LocationListener;  
import android.location.LocationManager;  
import android.location.Criteria;  
import android.webkit.WebView;  
import android.webkit.WebViewClient; 

/**
 *
 * @author Lou Jiwei 
 * @email  kkooff114@gmail.com
 * @create 2013-10-10 下午9:48:01
 * 
 */
public class GoogleMapActivity extends LJWBaseActivity implements LocationListener {  
//  private static final String MAP_URL = "http://gmaps-samples.googlecode.com/svn/trunk/articles-android-webmap/simple-android-map.html";  
  private static final String MAP_URL = "file:///android_asset/map_v3.html";  
  private WebView webView;  
  private Location mostRecentLocation;  
  
  @Override  
  /** Called when the activity is first created. */  
  public void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.map_v3);  
    //getLocation();
    new localSyn().execute("");
    //setupWebView();  
    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  
  
  }  
  private class localSyn extends AsyncTask<String, String, String>{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		getLocation();
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		setupWebView();
	}
	
	  
  }
  /** Sets up the WebView object and loads the URL of the page **/  
  @SuppressLint("JavascriptInterface")
private void setupWebView(){  
  
    webView = (WebView) findViewById(R.id.webview01);  
    webView.getSettings().setJavaScriptEnabled(true);  
    webView.setWebViewClient(new WebViewClient());  
    webView.loadUrl(MAP_URL);    
  
    /** Allows JavaScript calls to access application resources **/  
    webView.addJavascriptInterface(new JavaScriptInterface(), "android");  
  
  }  
  
  /** Sets up the interface for getting access to Latitude and Longitude data from device **/  
  private class JavaScriptInterface {  
    public double getLatitude(){  
      return mostRecentLocation.getLatitude();  
    }   
    public double getLongitude(){  
      return mostRecentLocation.getLongitude();  
    }  
  
  }  
  
  
  /** The Location Manager manages location providers. This code searches 
        for the best provider of data (GPS, WiFi/cell phone tower lookup, 
        some other mechanism) and finds the last known location. 
   **/  
  private void getLocation() {        
    LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);  
    Criteria criteria = new Criteria();  
    criteria.setAccuracy(Criteria.ACCURACY_FINE);  
    criteria.setAltitudeRequired(false);  
    criteria.setBearingRequired(false);  
    criteria.setCostAllowed(true);
    criteria.setPowerRequirement(Criteria.POWER_LOW);  
    String provider = locationManager.getBestProvider(criteria,true);  
  
    //In order to make sure the device is getting location, request updates.        locationManager.requestLocationUpdates(provider, 1, 0, this);  
    mostRecentLocation = locationManager.getLastKnownLocation(provider); 
  }  
  
  /** Sets the mostRecentLocation object to the current location of the device **/  
  @Override  
  public void onLocationChanged(Location location) {  
    mostRecentLocation = location;  
  }  
  
  /** The following methods are only necessary because WebMapActivity implements LocationListener **/   
  @Override  
  public void onProviderDisabled(String provider) {  
  }  
  
  @Override  
  public void onProviderEnabled(String provider) {  
  }  
  
  @Override  
  public void onStatusChanged(String provider, int status, Bundle extras) {  
  }  
  
} 
