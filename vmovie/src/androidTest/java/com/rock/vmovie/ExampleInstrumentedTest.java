package com.rock.vmovie;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.vmovie.bean.MovieDetail;
import com.rock.vmovie.ui.moviedetail.model.MovieDetailModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.rock.vmovie", appContext.getPackageName());
    }

    @Test
    public void testMovieDetail(){
        Log.e("TAG", "testMovieDetail: start" );
        MovieDetailModel movieDetailModel = new MovieDetailModel();
        Observable<MovieDetail> movieDetail = movieDetailModel.getMovieDetail(String.valueOf(50770));
        movieDetail.observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<MovieDetail>() {
            @Override
            public void onCompleted() {
                Log.e("TAG", "onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e("TAG", "onError: " );
            }

            @Override
            public void onNext(MovieDetail movieDetail) {
                Log.e("TAG", "onNext: " );
            }
        });
    }
}
