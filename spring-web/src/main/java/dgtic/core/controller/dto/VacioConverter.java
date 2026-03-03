package dgtic.core.controller.dto;

import java.beans.PropertyEditorSupport;

public class VacioConverter extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(text.isBlank()){
            throw new IllegalArgumentException();
        }
        setValue(text);
    }
}
