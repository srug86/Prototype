package com.example.ulabsrg.prototype.domain.record;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class RecordField {

    private String id;
    private String value;

    public RecordField(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
