package ua.dymohlo.reflection;
/*
Створіть анотацію @ShowInfo, яку можна ставити над полями. Ця анотація має вказувати, чи дозволено виводити дане поле в методі,
який виводитиме інформацію про об'єкт Student.
Для цього анотація має мати параметр boolean show зі значенням за замовчуванням true.
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShowInfo {
    boolean show() default true;
}
