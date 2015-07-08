package com.example.ulabsrg.prototype.domain.session;

import com.example.ulabsrg.prototype.domain.exception.TemplateNotFoundException;
import com.example.ulabsrg.prototype.domain.template.Category;
import com.example.ulabsrg.prototype.domain.template.CategoryCollection;
import com.example.ulabsrg.prototype.domain.template.Template;
import com.example.ulabsrg.prototype.domain.template.TemplateField;
import com.example.ulabsrg.prototype.domain.template.TemplateFieldCollection;
import com.example.ulabsrg.prototype.domain.user.User;
import com.example.ulabsrg.prototype.domain.template.FieldType;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class Session {

    private User user;
    private final Set<Template> templates;

    // TODO - Eliminar este metodo cuando los datos se obtengan de otro modo
    public Session() {
        User user = new User("ulabjdo@docpath.com");
        user.setName("John");
        user.setSurname("Doe");

        Set<Template> templates = new LinkedHashSet<Template>();

        // Template "SchoolData"
        Template template = new Template(UUID.randomUUID(), "1.2", "SchoolData");
        CategoryCollection categoryCollection = new CategoryCollection();

        // Identidad
        TemplateFieldCollection tFieldCollection = new TemplateFieldCollection();
        TemplateField tField = new TemplateField("Id_Name", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Id_Surname", FieldType.STRING);
        tFieldCollection.add(tField);
        Category category = new Category("Identity", tFieldCollection);
        categoryCollection.add(category);

        // Address
        tFieldCollection = new TemplateFieldCollection();
        tField = new TemplateField("Ad_Street", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ad_City", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ad_State", FieldType.STRING);
        tFieldCollection.add(tField);
        category = new Category("Address", tFieldCollection);
        categoryCollection.add(category);

        // Telephone
        tFieldCollection = new TemplateFieldCollection();
        tField = new TemplateField("Ph_Mobile", FieldType.PHONE);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ph_Home", FieldType.PHONE);
        tFieldCollection.add(tField);
        category = new Category("Phone", tFieldCollection);
        categoryCollection.add(category);

        // E-mail
        tFieldCollection = new TemplateFieldCollection();
        tField = new TemplateField("Em_Personal", FieldType.EMAIL);
        tFieldCollection.add(tField);
        tField = new TemplateField("Em_Work", FieldType.EMAIL);
        tFieldCollection.add(tField);
        category = new Category("Email", tFieldCollection);
        categoryCollection.add(category);

        template.setCategories(categoryCollection);
        templates.add(template);

        // Template "Credit Card Campaign"
        template = new Template(UUID.randomUUID(), "2.3", "Credit Card Campaign");
        categoryCollection = new CategoryCollection();

        // Identity
        tFieldCollection = new TemplateFieldCollection();
        tField = new TemplateField("Id_Name", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Id_Surname", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Id_Birth", FieldType.DATE);
        tFieldCollection.add(tField);
        tField = new TemplateField("Id_DNI", FieldType.DNI);
        tFieldCollection.add(tField);
        category = new Category("Identity", tFieldCollection);
        categoryCollection.add(category);

        // Address
        tFieldCollection = new TemplateFieldCollection();
        tField = new TemplateField("Ad_Street", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ad_City", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ad_State", FieldType.STRING);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ad_ZipCode", FieldType.NATURAL);
        tFieldCollection.add(tField);
        category = new Category("Address", tFieldCollection);
        categoryCollection.add(category);

        // Telephone
        tFieldCollection = new TemplateFieldCollection();
        tField = new TemplateField("Ph_Mobile", FieldType.PHONE);
        tFieldCollection.add(tField);
        tField = new TemplateField("Ph_Home", FieldType.PHONE);
        tFieldCollection.add(tField);
        category = new Category("Telephone", tFieldCollection);
        categoryCollection.add(category);

        template.setCategories(categoryCollection);
        templates.add(template);

        this.user = user;
        this.templates = templates;
    }

    public Session(User user, Set<Template> templates) {
        this.user = user;
        this.templates = templates;
    }

    public User getUser() {
        return user;
    }

    public Collection<Template> getTemplates() {
        return (Set<Template>) ((LinkedHashSet<Template>) templates).clone();
    }

    public Template getTemplateById(UUID templateId) throws TemplateNotFoundException {
        Template result = searchTemplateById(templateId);
        if (result == null) {
            throw new TemplateNotFoundException(
                    "The identifier" + templateId.toString() + "is not associated to any Template");
        }
        return result;
    }

    private Template searchTemplateById(UUID templateId) {
        Template result = null;
        for (Template template : templates) {
            if (template.getId().equals(templateId)) {
                result = template;
                break;
            }
        }
        return result;
    }
}
