package com.example.ulabsrg.prototype.domain.template;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class TemplateField {

    private String id;
    private FieldType type;

    public TemplateField(String id, FieldType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public FieldType getType() {
        return type;
    }
}
