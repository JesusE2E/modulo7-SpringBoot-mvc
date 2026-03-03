package dgtic.core.controller.dto;

import java.beans.PropertyEditorSupport;

public class MayusculasConverter extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null) {
            setValue(text.toUpperCase());
        } else {
            setValue(null);
        }
    }
}
