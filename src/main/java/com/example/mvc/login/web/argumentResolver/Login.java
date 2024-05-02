package com.example.mvc.login.web.argumentResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
// 리플렉션 등을 활용할 수 있도록 런타임까지 애노테이션 정보가 남아 있음
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
}
