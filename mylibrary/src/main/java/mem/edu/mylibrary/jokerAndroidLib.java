package mem.edu.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.endpoint.backend.myApi.MyApi;

import java.io.IOException;

//import com.example.Jocker;

/**
 * Created by erikllerena on 7/8/16.
 */
public class jokerAndroidLib extends ActionBarActivity {

    private ProgressBar spinner;

    public static interface JsonGetTaskListener {
        public void onComplete(String jsonString, Exception e);
    }

    private JsonGetTaskListener downloadListener;


    public class ProgressBarHandler {
        private ProgressBar mProgressBar;
        private Context mContext;

        public ProgressBarHandler(Context context) {
            mContext = context;

            ViewGroup layout = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();

            mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
            mProgressBar.setIndeterminate(true);

            RelativeLayout.LayoutParams params = new
                    RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

            RelativeLayout rl = new RelativeLayout(context);

            rl.setGravity(Gravity.CENTER);
            rl.addView(mProgressBar);

            layout.addView(rl, params);

            hide();
        }

        public void show() {
            mProgressBar.setVisibility(View.VISIBLE);
        }

        public void hide() {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //spinner.setVisibility(View.GONE);

        ProgressBarHandler mProgressBarHandler = new ProgressBarHandler(this); // In onCreate
        mProgressBarHandler.show(); // To show the progress bar


        Intent intent = getIntent();
        String joke;
        joke = intent.getStringExtra("joke");

        //Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();

        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, joke));
        //spinner.setVisibility(View.GONE);
        mProgressBarHandler.hide(); // To hide the progress bar

    }

}


class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;


    @Override
    protected String doInBackground(Pair<Context, String>... params) {


        if(myApiService == null) {  // Only do this once

            //rootUrl is the id given by the Google Cloud Endpoints
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://joketeller-1367.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
