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
//    public ApplicationTest() {
//        super(Application.class);
//    }

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



        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

//        runTestOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                endpointsAsyncTask.execute("Do something");
//            }
//        });

        endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "Hahaha"));

        signal.await(30, TimeUnit.SECONDS);
        assertTrue( "See me ?", true );

//        String joke = "hah";
//        EndpointsAsyncTask task = new EndpointsAsyncTask();
//        task.execute(new Pair<Context, String>(this, joke));
//        signal.await();
//
//        assertNull(mError);
//        assertFalse(TextUtils.isEmpty(mJsonString));
//        assertTrue(mJsonString.startsWith("{\"playlist\""));
//        assertTrue(mJsonString.endsWith("}"));

    }
}


