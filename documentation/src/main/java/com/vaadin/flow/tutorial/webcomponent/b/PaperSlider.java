package com.vaadin.flow.tutorial.webcomponent.b;

import com.vaadin.flow.component.AbstractSinglePropertyField;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.PropertyDescriptors;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.tutorial.annotations.CodeFor;
import com.vaadin.flow.tutorial.webcomponent.ClickEvent;

@CodeFor("web-components/creating-java-api-for-a-web-component.asciidoc")
//@formatter:off
@Tag("paper-slider")
@NpmPackage(value = "@polymer/paper-slider", version = "3.0.1")
@JsModule("@polymer/paper-slider/paper-slider.js")
public class PaperSlider extends AbstractSinglePropertyField<PaperSlider, Integer> {

    private static final PropertyDescriptor<Boolean, Boolean> pinProperty = PropertyDescriptors.propertyWithDefault("pin", false);

    public PaperSlider() {
        super("value", 0, false);
    }

    public void setPin(boolean pin) {
        pinProperty.set(this, pin);
    }

    public boolean isPin() {
        return pinProperty.get(this);
    }

    public Registration addClickListener(ComponentEventListener<ClickEvent> listener) {
        return addListener(ClickEvent.class, listener);
    }

    public void increment() {
        getElement().callJsFunction("increment");
    }
}
//@formatter:on
