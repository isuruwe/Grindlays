package grind.wsc.ht.mg;



import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.View;



import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


public class MangalamAct extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener,View.OnClickListener {
    public static final String RECEIVER_INTENT = "RECEIVER_INTENT";
    public static final String RECEIVER_MESSAGE = "RECEIVER_MESSAGE";
    private static final String CHANNEL_ID ="grinch2" ;
    private SliderLayout myclinder;
    private SliderLayout myclinder2;
    private int notiiiiid;

    public static    String gmlocds ="";
    private BroadcastReceiver brrecvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlay3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String channelId  = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));
        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Our Services", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                startActivity(new Intent(MangalamAct.this, mgmserzxc.class));

            }
        });

        myclinder = (SliderLayout)findViewById(R.id.slider);

        ImageView b1 = (ImageView)findViewById(R.id.button1);
        ImageView b2 = (ImageView) findViewById(R.id.button2);
        ImageView b3 = (ImageView) findViewById(R.id.button3);
        ImageView b4 = (ImageView) findViewById(R.id.button4);
        ImageView b5 = (ImageView) findViewById(R.id.button5);
        ImageView b6 = (ImageView) findViewById(R.id.button6);
        ImageView b7 = (ImageView) findViewById(R.id.button7);
        ImageView b8 = (ImageView) findViewById(R.id.button8);
        ImageView b9 = (ImageView) findViewById(R.id.button9);
        ImageView b10 = (ImageView) findViewById(R.id.button10);
        ImageView b11 = (ImageView) findViewById(R.id.button11);
        ImageView b12 = (ImageView) findViewById(R.id.button12);
        ImageView b13 = (ImageView) findViewById(R.id.button13);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Events",R.drawable.gmivi13);
        file_maps.put("Decor & Florists",R.drawable.gmivi14);
        file_maps.put("Event Planning",R.drawable.gmivi15);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);

            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);


          textSliderView.bundle(new Bundle());
           textSliderView.getBundle()
                   .putString("extra",name);

            myclinder.addSlider(textSliderView);
        }

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);


        myclinder.setPresetTransformer(SliderLayout.Transformer.Accordion);
        myclinder.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        myclinder.setCustomAnimation(new DescriptionAnimation());
        myclinder.setDuration(0);
        myclinder.addOnPageChangeListener(this);






        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b1.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b2.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b3.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b4.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b5.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b6.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b7.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b8.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b9.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b10.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b11.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b12.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            b13.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }


        findViewById(R.id.loadingPanel).setVisibility(View.GONE);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                Intent intent = new Intent(getBaseContext(), gmcadert.class);
                intent.putExtra("EXTRA_SESSION_ID", "1011");
                startActivity(intent);
                break;
            case R.id.button8:
                Intent intent8 = new Intent(getBaseContext(), gmcadert.class);
                intent8.putExtra("EXTRA_SESSION_ID", "5");
                startActivity(intent8);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(getBaseContext(), gmcadert.class);
                intent2.putExtra("EXTRA_SESSION_ID", "3");
                startActivity(intent2);
                break;
            case R.id.button11:
                Intent intent11 = new Intent(getBaseContext(), gmcadert.class);
                intent11.putExtra("EXTRA_SESSION_ID", "1014");
                startActivity(intent11);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(getBaseContext(), gmcadert.class);
                intent5.putExtra("EXTRA_SESSION_ID", "2");
                startActivity(intent5);
                break;

            case R.id.button4:
                Intent intent4 = new Intent(getBaseContext(), gmcadert.class);
                intent4.putExtra("EXTRA_SESSION_ID", "1012");
                startActivity(intent4);
                break;

            case R.id.button6:
                Intent intent6 = new Intent(getBaseContext(), gmcadert.class);
                intent6.putExtra("EXTRA_SESSION_ID", "9");
                startActivity(intent6);
                break;


            case R.id.button9:
                Intent intent9 = new Intent(getBaseContext(), gmcadert.class);
                intent9.putExtra("EXTRA_SESSION_ID", "6");
                startActivity(intent9);
                break;
            case R.id.button7:
                Intent intent7 = new Intent(getBaseContext(), gmcadert.class);
                intent7.putExtra("EXTRA_SESSION_ID", "7");
                startActivity(intent7);
                break;
            case R.id.button10:
                Intent intent10 = new Intent(getBaseContext(), gmcadert.class);
                intent10.putExtra("EXTRA_SESSION_ID", "1013");
                startActivity(intent10);
                break;

            case R.id.button12:
                Intent intent12 = new Intent(getBaseContext(), gmcadert.class);
                intent12.putExtra("EXTRA_SESSION_ID", "10");
                startActivity(intent12);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(getBaseContext(), gmcadert.class);
                intent3.putExtra("EXTRA_SESSION_ID", "4");
                startActivity(intent3);
                break;
            case R.id.button13:
                Intent intent13 = new Intent(getBaseContext(), gmcadert.class);
                intent13.putExtra("EXTRA_SESSION_ID", "14");
                startActivity(intent13);
                break;

            default:
                break;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(MangalamAct.this, mgmserzxc.class));
        }
        else if (id == R.id.nav_web) {

            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.grindlaysmangalam.com"));
            startActivity(i);


        }
        else if (id == R.id.nav_manage) {
            startActivity(new Intent(MangalamAct.this, findUs.class));
        }
        else if (id == R.id.nav_gallery) {
            startActivity(new Intent(MangalamAct.this, AboutUs.class));
        }
        else if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+94713409409"));
            startActivity(intent);
        }
        else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(MangalamAct.this, conform.class));
        }
        else if (id == R.id.nav_send) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "info@grindlaysmangalam.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hi");
            startActivity(Intent.createChooser(emailIntent, null));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    public StateListDrawable makeSelector(int color) {
        StateListDrawable res = new StateListDrawable();
        res.setExitFadeDuration(400);
        res.setAlpha(200);
        res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
        Drawable d = getResources().getDrawable(R.drawable.gmrnfbn);
        res.addState(new int[]{},d);


        return res;
    }






}
