package grind.wsc.ht.mg;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class mgmserzxc extends AppCompatActivity implements View.OnClickListener{
    public StateListDrawable makeSelector(int color) {
        StateListDrawable res = new StateListDrawable();
        res.setExitFadeDuration(400);
        res.setAlpha(200);
        res.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(color));
        Drawable d = getResources().getDrawable(R.drawable.gmrnfbn);
        res.addState(new int[]{},d);


        return res;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmlay4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView mgm1 = (ImageView) findViewById(R.id.button1);

        mgm1.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm1.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        ImageView mgm10 = (ImageView) findViewById(R.id.button10);

        mgm10.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm10.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }


        ImageView mgm4 = (ImageView) findViewById(R.id.button4);


        mgm4.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm4.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        ImageView mgm12 = (ImageView) findViewById(R.id.button12);

        mgm12.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm12.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        ImageView mgm5 = (ImageView) findViewById(R.id.button5);

        mgm5.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm5.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        ImageView mgm6 = (ImageView) findViewById(R.id.button6);

        mgm6.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm6.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        ImageView mgm7 = (ImageView) findViewById(R.id.button7);

        mgm7.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm7.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        ImageView mgm3 = (ImageView) findViewById(R.id.button3);

        mgm3.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm3.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        ImageView mgm8 = (ImageView) findViewById(R.id.button8);

        mgm8.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm8.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
        ImageView mgm2 = (ImageView) findViewById(R.id.button2);
        mgm2.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm2.setBackground(makeSelector(Color.parseColor("#ff7200")));
        }
        ImageView mgm9 = (ImageView) findViewById(R.id.button9);

        mgm9.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm9.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }

        ImageView mgm11 = (ImageView) findViewById(R.id.button11);

        mgm11.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm11.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }

        ImageView mgm13 = (ImageView) findViewById(R.id.button13);

        mgm13.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mgm13.setBackground(makeSelector(Color.parseColor("#ff4600")));
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button5:
                Intent intent5 = new Intent(getBaseContext(), gmcadert.class);
                intent5.putExtra("EXTRA_SESSION_ID", "2");
                startActivity(intent5);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(getBaseContext(), gmcadert.class);
                intent2.putExtra("EXTRA_SESSION_ID", "3");
                startActivity(intent2);
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
            case R.id.button1:
                Intent intent = new Intent(getBaseContext(), gmcadert.class);
                intent.putExtra("EXTRA_SESSION_ID", "1011");
                startActivity(intent);
                break;
            case R.id.button7:
                Intent intent7 = new Intent(getBaseContext(), gmcadert.class);
                intent7.putExtra("EXTRA_SESSION_ID", "7");
                startActivity(intent7);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(getBaseContext(), gmcadert.class);
                intent3.putExtra("EXTRA_SESSION_ID", "4");
                startActivity(intent3);
                break;
            case R.id.button8:
                Intent intent8 = new Intent(getBaseContext(), gmcadert.class);
                intent8.putExtra("EXTRA_SESSION_ID", "5");
                startActivity(intent8);
                break;
            case R.id.button11:
                Intent intent11 = new Intent(getBaseContext(), gmcadert.class);
                intent11.putExtra("EXTRA_SESSION_ID", "1014");
                startActivity(intent11);
                break;
            case R.id.button9:
                Intent intent9 = new Intent(getBaseContext(), gmcadert.class);
                intent9.putExtra("EXTRA_SESSION_ID", "6");
                startActivity(intent9);
                break;


            case R.id.button12:
                Intent intent12 = new Intent(getBaseContext(), gmcadert.class);
                intent12.putExtra("EXTRA_SESSION_ID", "10");
                startActivity(intent12);
                break;
            case R.id.button10:
                Intent intent10 = new Intent(getBaseContext(), gmcadert.class);
                intent10.putExtra("EXTRA_SESSION_ID", "1013");
                startActivity(intent10);
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
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == android.R.id.home) {

            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
