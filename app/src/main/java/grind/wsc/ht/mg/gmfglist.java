package grind.wsc.ht.mg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;


public class gmfglist extends AppCompatActivity {

    private String strbvhk;
    private String sdfgn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlay18);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String sessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");


         grtycv(sessionId);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String grtycv(String  val1 ){
        String url = "http://www.grindlaysmangalam.com/android/getmsg.ashx?devid="+val1+"";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        strbvhk = response.toString();


                        chngwhab();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {



                    }
                });


        singletongm.getInstance(this).addToRequestQueue(jsonObjectRequest);
return strbvhk;
    }
    public void chngwhab(){
        try{

            JSONObject dbovh = null;

            dbovh = new JSONObject(strbvhk);

            JSONArray we = null;

            we = dbovh.getJSONArray("Table");



            int b=0;

            for (int row = 0; row < (we.length()); row++) {

                    JSONObject we1 = we.getJSONObject(b);

                    String gmname = we1.get("Name").toString();
                String gmdecsrip = we1.get("Description").toString();
                String gmaddrr = we1.get("Address").toString();
                String gmcontc = we1.get("ContactNos").toString();
                 String gmurl = we1.get("WebUrl").toString();
                String gmmail = we1.get("Email").toString();
                String gmbrnck = we1.get("Branches").toString();
                String gmodeta = we1.get("OtherDetail").toString();
                final String gmfblnj = we1.get("FbLink").toString();
                final String gmytub = we1.get("YoutubeLink").toString();




                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.gmlay17, null);

                ImageView ImageView1 = (ImageView) v.findViewById(R.id.imageButton);
                ImageView1.setImageResource(R.drawable.gmmel1);
                ImageView ImageView7 = (ImageView) v.findViewById(R.id.imageView7);
                ImageView7.setImageResource(R.drawable.gmivi21);

                ImageView ImageView3 = (ImageView) v.findViewById(R.id.imageView5);
                ImageView3.setImageResource(android.R.drawable.ic_menu_call);



                ImageView ImageView4 = (ImageView) v.findViewById(R.id.imageView6);
                ImageView4.setImageResource(R.drawable.gmblgco);

                ImageView ImageView2 = (ImageView) v.findViewById(R.id.imageView4);
                ImageView2.setImageResource(R.drawable.gmivi16);

                ImageView ImageView8 = (ImageView) v.findViewById(R.id.imageView8);
                ImageView8.setImageResource(R.drawable.gmivi2);

                if(gmfblnj!="null"){

                    ImageView8.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse(gmfblnj));
                            startActivity(intent);
                        }
                    });
                }
                else {
                    ImageView8.setVisibility(View.GONE);

                }
                if(gmytub!="null"){
                    ImageView7.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse(gmytub));
                            startActivity(intent);
                        }
                    });

                }
                else {
                    ImageView7.setVisibility(View.GONE);

                }



                TextView textView6 = (TextView) v.findViewById(R.id.textView6);
                if(gmodeta!="null"){textView6.setText(gmodeta);}
                else {
                    textView6.setVisibility(View.GONE);

                }

                TextView textView3 = (TextView) v.findViewById(R.id.textView3);
                if(gmaddrr!="null"){textView3.setText(gmaddrr);}
                else {
                    textView3.setVisibility(View.GONE);
                    ImageView1.setVisibility(View.GONE);
                }

                TextView textView4 = (TextView) v.findViewById(R.id.textView4);
                if(gmmail!="null"){textView4.setText(gmmail);}
                else {
                    textView4.setVisibility(View.GONE);
                    ImageView2.setVisibility(View.GONE);
                }
                TextView textView = (TextView) v.findViewById(R.id.vname);
                if(gmname!="null"){ textView.setText(gmname);}
                TextView textView2 = (TextView) v.findViewById(R.id.textView2);
                if(gmdecsrip!="null"){textView2.setText(gmdecsrip);}
                else {
                    textView2.setVisibility(View.GONE);

                }

                TextView textView5 = (TextView) v.findViewById(R.id.textView5);
                if(gmcontc!="null"){textView5.setText(gmcontc);}
                else {
                    textView5.setVisibility(View.GONE);
                    ImageView3.setVisibility(View.GONE);
                }



                TextView textView7 = (TextView) v.findViewById(R.id.textView7);
                if(gmurl!="null"){textView7.setText(gmurl);


                if (!gmurl.startsWith("http")){

                    final String w2="http://"+gmurl;
                    textView7.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse(w2));
                            startActivity(intent);
                        }
                    });
                    }
                    else{
                    final String w2=gmurl;
                    textView7.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse(w2));
                            startActivity(intent);
                        }
                    });

                }




                }
                else {
                    textView7.setVisibility(View.GONE);
                    ImageView4.setVisibility(View.GONE);
                }
                TextView textView9 = (TextView) v.findViewById(R.id.textView9);
                TextView textView8 = (TextView) v.findViewById(R.id.textView8);
                if(gmbrnck!="null"){textView8.setText(gmbrnck);

                    textView9.setText("Branches:");
                }
                else {
                    textView9.setVisibility(View.GONE);
                    textView8.setVisibility(View.GONE);

                }


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


                ViewGroup insertPoint = (ViewGroup) findViewById(R.id.commentWrapper);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


                findViewById(R.id.loadingPanel).setVisibility(View.GONE);

            b++;
               }




        } catch (NullPointerException ex){

        } catch (Exception e){

        }

    }




}
