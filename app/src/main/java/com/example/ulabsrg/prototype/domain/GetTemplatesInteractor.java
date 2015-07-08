package com.example.ulabsrg.prototype.domain;

import com.example.ulabsrg.prototype.domain.session.Session;
import com.example.ulabsrg.prototype.domain.template.Template;
import com.example.ulabsrg.prototype.executor.Executor;
import com.example.ulabsrg.prototype.executor.Interactor;
import com.example.ulabsrg.prototype.executor.MainThread;
import com.example.ulabsrg.prototype.util.RandomUtils;

import java.util.Collection;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class GetTemplatesInteractor implements Interactor, GetTemplates {

    private static final int PERCENTAGE_OF_FAILS = 50;
    public static final int WAIT_TIME = 1500;

    private final Session session;
    private final Executor executor;
    private final MainThread mainThread;

    private Callback callback;

    GetTemplatesInteractor(Session session, Executor executor, MainThread mainThread) {
        this.session = session;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void execute(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException(
                    "Callback can't be null, the client of this interactor needs to get the response "
                            + "in the callback");
        }
        this.callback = callback;
        this.executor.run(this);
    }

    @Override
    public void run() {
        waitToDoThisSampleMoreInteresting();

        if (haveToShowError()) {
            notifyError();
        } else {
            Collection<Template> templates = session.getTemplates();
            nofityTemplatesLoaded(templates);
        }
    }

    /**
     * To simulate a we are getting the TvShows data from internet we are going to force a 1.5
     * seconds
     * delay using Thread.sleep.
     */
    private void waitToDoThisSampleMoreInteresting() {
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            //Empty
        }
    }

    private boolean haveToShowError() {
        return RandomUtils.percent(PERCENTAGE_OF_FAILS);
    }

    private void notifyError() {
        mainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void nofityTemplatesLoaded(final Collection<Template> templates) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onTemplatesLoaded(templates);
            }
        });
    }
}
