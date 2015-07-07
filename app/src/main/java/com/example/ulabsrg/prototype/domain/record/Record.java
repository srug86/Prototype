package com.example.ulabsrg.prototype.domain.record;

import java.util.UUID;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class Record {

    private UUID id;
    private RecordFieldCollection fields;

    public Record(UUID id, RecordFieldCollection fields) {
        this.id = id;
        this.fields = fields;
    }

    public UUID getId() {
        return id;
    }

    public RecordFieldCollection getFields() {
        return fields;
    }
}
