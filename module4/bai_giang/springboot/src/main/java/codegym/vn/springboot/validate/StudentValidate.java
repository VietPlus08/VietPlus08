package codegym.vn.springboot.validate;

import codegym.vn.springboot.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (!(target instanceof Student)) {
            return;
        }
        Student student = (Student) target;
        if (student.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
        } else if (!student.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
        }
    }
}
