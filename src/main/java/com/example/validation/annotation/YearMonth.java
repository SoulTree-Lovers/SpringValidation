package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import com.example.validation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) // 변수에만 적용
@Retention(RetentionPolicy.RUNTIME) // 실행 중에만 어노테이션이 작동
@Constraint(validatedBy = {YearMonthValidator.class}) // 어떤 클래스로 검증할 것인지 설정
@NotBlank // 공백 허용 x
public @interface YearMonth {

    String message() default "날짜 양식에 맞지 않습니다. ex) 2024-01";

    String pattern() default "yyyy-MM";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
