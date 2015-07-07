package com.example.ulabsrg.prototype.domain.template;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class Category {

    private String name;
    private TemplateFieldCollection fields;

    public Category(String name, TemplateFieldCollection fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public TemplateFieldCollection getFields() {
        return fields;
    }
}
