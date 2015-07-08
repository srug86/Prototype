package com.example.ulabsrg.prototype.domain.template;

import java.util.UUID;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class Template {

    private UUID id;
    private String version;
    private String name;
    private CategoryCollection categories;

    public Template(UUID id, String version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryCollection getCategories() {
        return categories;
    }

    public void setCategories(CategoryCollection categories) {
        this.categories = categories;
    }
}
