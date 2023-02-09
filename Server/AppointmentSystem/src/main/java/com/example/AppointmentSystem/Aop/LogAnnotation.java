package com.example.AppointmentSystem.Aop;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String operation() default "";
    String creator() default "";
    String operation_time() default "";

}
