package com.example.ulabsrg.prototype.domain;

import com.example.ulabsrg.prototype.domain.template.Template;

import java.util.UUID;

/**
 * Created by ulabsrg on 08/07/2015.
 */
public interface GetTemplateById {

    interface Callback {
        void onTemplateLoaded(final Template template);

        void onTemplateNotFound();

        void onConnectionError();
    }

    void execute(final UUID templateId, final Callback callback);
}
