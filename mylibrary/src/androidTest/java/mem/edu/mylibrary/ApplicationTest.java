package mem.edu.mylibrary;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.text.TextUtils;
import android.util.Pair;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    String mJsonString = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testAlbumGetTask() throws Throwable {


        //just testing the AsyncTask with "hahaha"
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "Hahaha"));

        //got to wait for the server's response
        signal.await(30, TimeUnit.SECONDS);
        assertTrue( "See me ?", true );

    }
}


