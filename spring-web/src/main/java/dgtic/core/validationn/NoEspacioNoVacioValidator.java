package dgtic.core.validationn;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoEspacioNoVacioValidator implements ConstraintValidator<NoEspacioNoVacio,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //logica de validacion
        if(s==null || s.regionMatches(0," ",0,1) || s.isBlank()){
            return false;
        }


        return true;
    }
}
