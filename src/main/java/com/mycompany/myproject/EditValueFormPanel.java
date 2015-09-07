package com.mycompany.myproject;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public class EditValueFormPanel extends Panel {
    public EditValueFormPanel(String id, final HomePage page) {
        super(id);
        Form form = new Form("myInnerForm");

        Component text = new TextField<>("myField", new PropertyModel<String>(page, "value"));
        form.add(text);
        AjaxSubmitLink link = new AjaxSubmitLink("slink", form){
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);
                ModalWindow.closeCurrent(target);
            }
        };
        form.add(link);
        add(form);
    }

}
