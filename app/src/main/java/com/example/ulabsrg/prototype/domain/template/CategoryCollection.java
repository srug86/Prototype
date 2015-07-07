package com.example.ulabsrg.prototype.domain.template;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class CategoryCollection implements Iterable<Category> {

    private final Set<Category> categories;

    public CategoryCollection() { this.categories = new LinkedHashSet<Category>(); }

    public Collection<Category> getCategories() {
        return (Collection<Category>) ((LinkedHashSet<Category>) categories).clone();
    }

    public void add(Category category) { this.categories.add(category); }

    @Override
    public Iterator<Category> iterator() {
        return this.categories.iterator();
    }
}
