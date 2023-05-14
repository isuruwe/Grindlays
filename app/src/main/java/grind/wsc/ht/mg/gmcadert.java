package grind.wsc.ht.mg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;


import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class gmcadert extends AppCompatActivity implements View.OnClickListener {

    private String changeres;
    private int mywd2;
    private int myht2;
    private float myden2;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlay16);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String sessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");


        getdmsg(sessionId);

    }
    private void setgmviews(int layoutHeight, int layoutWidth, int cnt) {

        try{

            JSONObject jsonObject = null;

            jsonObject = new JSONObject(changeres);

            JSONArray we = null;

            we = jsonObject.getJSONArray("Table");
            Log.wtf("fff", Integer.toString(we.length()));


            int b=0;
            int width = mywd2;
            int height = 260;

            ArrayList<String> data = new ArrayList<>();
            data.clear();

            TableLayout table = new TableLayout(getApplicationContext());

            table.removeAllViews();
            TableRow[] tableRow = new TableRow[(we.length())];

            Random random = new Random();
            int num = (we.length());


            for (int row = 0; row < num; row++) {
                JSONObject we1 = we.getJSONObject(b);

                String s1 = we1.get("Name").toString();
                final String t1 = we1.get("UId").toString();
                String u1 = we1.get("Address").toString();
                String v1 = we1.get("ContactNos").toString();



                tableRow[b] = new TableRow(getApplicationContext());
                tableRow[b].setGravity(Gravity.CENTER);

                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.gmlay19,null);

                String imn=   we1.get("ProfilePicPath").toString();


                final ImageView mImageView;
                String url = "http://www.grindlaysmangalam.com/Assets/images/CategoryList/"+imn;
                mImageView = (ImageView) v.findViewById(R.id.imageView3);



                ImageRequest request = new ImageRequest(url,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap bitmap) {
                                mImageView.setImageBitmap(bitmap);
                            }
                        }, 0, 0, null,null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                    }
                }
                );

                singletongm.getInstance(this).addToRequestQueue(request);
                mImageView.getLayoutParams().width =getResources().getDimensionPixelSize(R.dimen.dimen_ent_in_dp);
                mImageView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.dimen_ent_in_dp);
                mImageView.setId(row);
                mImageView.setClickable(true);
                mImageView.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        Intent i = new Intent(gmcadert.this, gmfglist.class);
                        i.putExtra("EXTRA_SESSION_ID",t1);
                        startActivity(i);
                    }
                });
                TextView textView = (TextView) v.findViewById(R.id.textView2);
                textView.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.dimen_ent_in_dp);
                textView.setClickable(true);
                textView.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        Intent i = new Intent(gmcadert.this, gmfglist.class);
                        i.putExtra("EXTRA_SESSION_ID",t1);
                        startActivity(i);
                    }
                });


                if(s1!="null"){ textView.setText(s1);}
                textView.setId(row);

                if ( (b & 1) == 0 ){
                    tableRow[b].addView(v);

                }
                else {
                    tableRow[b-1].addView(v);
                }
                Log.wtf("ttt",Integer.toString((we.length())));
                if ( row==(we.length()-1)&&((we.length()) & 1) != 0){
                    LayoutInflater vi1 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View v11 = vi1.inflate(R.layout.gmlay10,null);
                    tableRow[b].addView(v11);


                }
                if(we.length()==1){
                    LayoutInflater vi1 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View v11 = vi1.inflate(R.layout.gmlay10,null);
                    tableRow[row].addView(v11);
                    Log.wtf("rrr",Integer.toString(row));
                }
                else {

                }

                table.setStretchAllColumns(true);
                table.addView(tableRow[b]);



                b++;
            }
            ConstraintLayout container = (ConstraintLayout) findViewById(R.id.tblatuot);

            container.addView(table);
        } catch (NullPointerException ex){
            Log.wtf("rrr",ex.toString());
        } catch (Exception e){
            Log.wtf("tt",e.toString());
        }

        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }


    @Override
    public void onClick(View view) {

    }
    public String getdmsg(String  val1 ){
        String url = "http://www.grindlaysmangalam.com/android/getmain.ashx?devid="+val1+"";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        changeres = response.toString();


                        setgmviews(250, 200,5);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {




                    }
                });


        singletongm.getInstance(this).addToRequestQueue(jsonObjectRequest);
        return changeres;
    }


}
