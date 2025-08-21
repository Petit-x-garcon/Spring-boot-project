package com.group.ecommerce.Common.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
public @interface ValidEnum {
    String message() default "Invalid value";
    Class<? extends Enum<?>> enumClass();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
