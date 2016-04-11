package com.example.shobhana.feature3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;


public class Gps {

    private LocationManager mlocation;
    private LocationListener nlocation;
    private Location llocation;

    String provider = "";
    Context context;
    double lat,lng;
    String latlng,lastLocation;

    public Gps(Context context) {

        this.context = context;
    }


    public void getLocation() {


        mlocation = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        /*Criteria criteria = new Criteria();
        provider = mlocation.getBestProvider(criteria, false);
        llocation = mlocation.getLastKnownLocation(provider);

        System.out.println("location "+llocation);

        if(llocation!=null)
            lastLocation=llocation.getLatitude()+","+llocation.getLongitude();*/

        nlocation = new gpsLocation();

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mlocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, nlocation);


    }

    public String getCoordinates(){

        //if(latlng!=null)
            return latlng;

        //else
          //  return lastLocation;
    }

    private class gpsLocation implements LocationListener{

        //all overriden method definitions are auto generated

        String coordinates;

        @Override
        public void onLocationChanged(Location location) {

            lat=location.getLatitude();
            lng=location.getLongitude();

            latlng=lat+","+lng;
            System.out.println("latlng"+latlng);


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }


    }
}
