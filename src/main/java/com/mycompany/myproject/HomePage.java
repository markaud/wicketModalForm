package com.mycompany.myproject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    private String value = "Default";

	public HomePage(final PageParameters parameters) {
		super(parameters);

        final Label valueLabel = new Label("value", new PropertyModel<>(this, "value"));
        valueLabel.setOutputMarkupId(true);
        add(valueLabel);

        final ModalWindow popup = new ModalWindow("popup");
        popup.setContent(new EditValueFormPanel(popup.getContentId(), this));
        popup.setWindowClosedCallback(new ModalWindow.WindowClosedCallback() {
            @Override
            public void onClose(AjaxRequestTarget ajaxRequestTarget) {
                ajaxRequestTarget.add(valueLabel);
            }
        });
        add(popup);

        add(new AjaxLink<String>("link") {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                popup.show(ajaxRequestTarget);
            }
        });
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
