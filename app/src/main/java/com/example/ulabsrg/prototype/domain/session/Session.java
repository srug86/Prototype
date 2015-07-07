package com.example.ulabsrg.prototype.domain.session;

import com.example.ulabsrg.prototype.domain.template.TemplateCollection;
import com.example.ulabsrg.prototype.domain.user.User;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class Session {

    private User user;
    private TemplateCollection templates;

    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public TemplateCollection getTemplateCollection() {
        return templates;
    }
}
