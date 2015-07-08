package com.example.ulabsrg.prototype.domain;

import com.example.ulabsrg.prototype.domain.template.Template;

import java.util.Collection;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public interface GetTemplates {

    interface Callback {
        void onTemplatesLoaded(final Collection<Template> templates);

        void onConnectionError();
    }

    void execute(Callback callback);
}
