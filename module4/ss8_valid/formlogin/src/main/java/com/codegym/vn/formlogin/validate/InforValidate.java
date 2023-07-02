package com.codegym.vn.formlogin.validate;

import com.codegym.vn.formlogin.entity.Infor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.sound.sampled.Line;
import java.util.Set;

public class InforValidate implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Infor.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Infor)){
            return;
        }
        Infor infor = (Infor) target;
        if (infor.getIdentityNumber().length() != 10){
            errors.rejectValue("identityNumber","identity number","phone is not valid");
        } else if (!infor.getIdentityNumber().startsWith("0")) {
            errors.rejectValue("identityNumber","identity start","must start with 0");
        }

    }
}
