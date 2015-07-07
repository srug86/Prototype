package com.example.ulabsrg.prototype.domain.template;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class TemplateFieldCollection implements Iterable<TemplateField> {

    private final Set<TemplateField> fields;

    public TemplateFieldCollection() { this.fields = new LinkedHashSet<TemplateField>(); }

    public Collection<TemplateField> getFields() {
        return (Collection<TemplateField>) ((LinkedHashSet<TemplateField>) fields).clone();
    }

    public void add(TemplateField field) { this.fields.add(field); }

    @Override
    public Iterator<TemplateField> iterator() {
        return this.fields.iterator();
    }
}
