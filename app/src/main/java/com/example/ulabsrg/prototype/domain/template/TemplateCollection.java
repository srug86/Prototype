package com.example.ulabsrg.prototype.domain.template;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class TemplateCollection implements Iterable<Template> {

    private final Set<Template> templates;

    public TemplateCollection() { this.templates = new LinkedHashSet<Template>(); }

    public Collection<Template> getTemplates() {
        return (Collection<Template>) ((LinkedHashSet<Template>) templates).clone();
    }

    public void add(Template template) { this.templates.add(template); }

    @Override
    public Iterator<Template> iterator() {
        return templates.iterator();
    }
}
