package ua.dymohlo.hw6;

/*
Найти и исправить ошибку в коде с помощью дебаггера
 */
public class Task2 {
    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = 0;
            }
            System.out.println(triangle[i].length);
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*
Смотря на вывод в консоль предположил, что ошибка состоит в том, что при каждой итерации( кроме первой) выводяться
лишние элементы. Проблему в коде определил следующим образом: с помощью Line breakpoint пробежался по коду начиная
с первого цикла и обнаружил что ошибка находится во втором цикле. println выводит результат после каждой итерации
цикла, в следствии чего на консоль выводятся лишние элементы в количестве зависящем от количества итераций внутри
второго цикла. Проблему решил выносом строки "System.out.println(triangle[i].length);" за пределы цикла.
После дополнительного просмотра кода предположил, что автор хотел вывести в консоль двумерный массив со значениям ноль.
Добавил еще один цикл в методю
*/