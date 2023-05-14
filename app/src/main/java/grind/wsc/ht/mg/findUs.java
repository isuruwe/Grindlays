package grind.wsc.ht.mg;

import android.os.Bundle;

import android.view.MenuItem;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;

public class findUs extends AppCompatActivity implements OnMapReadyCallback
         {
             private GoogleMap mp1;
             @Override
             public void onMapReady(GoogleMap googleMap) {
                 try {
                     mp1 = googleMap;
                     mp1.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                     // Add a marker in Sydney, Australia, and move the camera.
                     LatLng sydney = new LatLng(7.290572, 80.244525);
                     mp1.addMarker(new MarkerOptions().position(sydney).title("Grindlays Regency Hotels").snippet("Ranwala Road, Alawwa," +
                             "Sri Lanka"));
                     mp1.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                     mp1.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney,18));
                 }catch (Exception ex){


                 }
             }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlay12);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



         }