package com.example.ulabsrg.prototype.domain.record;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class RecordFieldCollection implements Iterable<RecordField> {

    private final Set<RecordField> fields;

    public RecordFieldCollection() {
        this.fields = new LinkedHashSet<RecordField>();
    }

    public Collection<RecordField> getRecordFields() {
        return (Collection<RecordField>) ((LinkedHashSet<RecordField>) this.fields).clone();
    }

    public void add(RecordField field) { this.fields.add(field); }

    @Override
    public Iterator<RecordField> iterator() {
        return this.fields.iterator();
    }
}
