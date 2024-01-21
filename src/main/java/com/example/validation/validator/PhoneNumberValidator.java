package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private String regexp;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) { // 검증하는 부분
//        boolean result = Pattern.matches(value, regexp); --> 정규식과 완전히 일치하는 지 판별
        // 수정된 부분: Pattern.compile(regexp).matcher(value).matches() 사용
        boolean result = Pattern.compile(regexp).matcher(value).matches();

        return result;
    }
}
