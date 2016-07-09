package mem.edu.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.Jocker;

/**
 * Created by erikllerena on 7/8/16.
 */
public class jokerAndroidLib extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String joke;
        joke = intent.getStringExtra("joke");

        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }

}
