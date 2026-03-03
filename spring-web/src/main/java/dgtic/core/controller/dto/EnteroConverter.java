package dgtic.core.controller.dto;

import java.beans.PropertyEditorSupport;

public class EnteroConverter  extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Integer.parseInt(text);
        }catch (NumberFormatException ex){
            text="0";
        }
        setValue(text);
    }
}
