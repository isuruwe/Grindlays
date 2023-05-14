package grind.wsc.ht.mg;

import android.util.Log;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class mjsact extends JobService {

    private static final String TAG = "mjsact";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "job");

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}
