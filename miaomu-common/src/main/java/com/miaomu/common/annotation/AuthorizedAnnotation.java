package com.miaomu.common.annotation;

import java.lang.annotation.*;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/11/17 13:12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorizedAnnotation {
    String code() default "";
}