package ua.dymohlo.reflection;

import java.lang.reflect.Field;

/*
Створіть клас StudentInfoPrinter, який має наступний метод:

public void printStudentInfo(Student student)
Цей метод має використовувати рефлексію для виведення інформації про студента. Виводити повинніся лише ті поля,
які анотовані анотацією @ShowInfo з параметром show=true. Інформація повинна виводитися в форматі:

Ім'я: {ім'я студента}
Прізвище: {прізвище студента}
Вік: {вік студента}
*/
public class StudentInfoPrinter {

    public String printStudentInfo(Student student) throws IllegalAccessException {
        String studentInfo = "";
        Class<? extends Student> printStudentInfoClass = student.getClass();
        Field[] declaredFields = printStudentInfoClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            boolean annotationPresent = declaredField.isAnnotationPresent(ShowInfo.class);
            if (annotationPresent) {
                studentInfo += (declaredField.get(student) + " ");
            }
        }
        return studentInfo;
    }
}
