package com.example.ulabsrg.prototype.domain;

import com.example.ulabsrg.prototype.domain.exception.TemplateNotFoundException;
import com.example.ulabsrg.prototype.domain.session.Session;
import com.example.ulabsrg.prototype.domain.template.Template;
import com.example.ulabsrg.prototype.executor.Executor;
import com.example.ulabsrg.prototype.executor.Interactor;
import com.example.ulabsrg.prototype.executor.MainThread;
import com.example.ulabsrg.prototype.util.RandomUtils;

import java.util.UUID;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public class GetTemplateByIdInteractor implements Interactor, GetTemplateById {

    private static final int PERCENTAGE_OF_FAILS = 50;
    private static final long WAIT_TIME = 1500;

    private final Executor executor;
    private final MainThread mainThread;
    private final Session session;

    private UUID templateId;
    private Callback callback;

    GetTemplateByIdInteractor(Session session, Executor executor, MainThread mainThread) {
        this.session = session;
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void execute(final UUID templateId, final Callback callback) {
        validateArguments(callback, templateId);
        this.callback = callback;
        this.templateId = templateId;
        this.executor.run(this);
    }

    @Override
    public void run() {
        waitToDoThisSampleMoreInteresting();

        if (haveToShowError()) {
            notifyConnectionError();
        } else {
            searchTemplate();
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

    private void searchTemplate() {
        Template template = null;
        try {
            template = this.session.getTemplateById(templateId);
        } catch (TemplateNotFoundException e) {
            notifyTemplateNotFound();
        }
        notifyTemplateFound(template);
    }

    private void validateArguments(Callback callback, UUID templateId) {
        if (templateId == null) {
            throw new IllegalArgumentException("TemplateId parameter can't be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback parameter can't be null");
        }
    }

    private void notifyConnectionError() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void notifyTemplateFound(final Template template) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onTemplateLoaded(template);
            }
        });
    }

    private void notifyTemplateNotFound() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onTemplateNotFound();
            }
        });
    }
}
