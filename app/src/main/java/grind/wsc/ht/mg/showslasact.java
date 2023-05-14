package grind.wsc.ht.mg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class showslasact extends Activity {
    private final int lenghtoddy = 1000;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.gmlay15);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(showslasact.this, MangalamAct.class);
                showslasact.this.startActivity(mainIntent);
                showslasact.this.finish();
            }
        }, lenghtoddy);
    }


}
