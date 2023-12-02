package ua.dymohlo.moduletwo;
/*
Молоко|2|1.5
Яйца|10|0.2
Огурцы|5|0.8
Хлеб|1|1.0
Сыр|3|2.5
Яблоки|6|1.2
Курица|2|5.0


Отфильтровать продукты с количеством больше заданного значения
Подсчитать общее количество продуктов в холодильнике.
Найти среднюю цену продуктов.
Отсортировать продукты по цене в порядке убывания.
Подсчитать общую стоимость продуктов (цена * количество).
*/


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("C:\\Users\\DELL\\IdeaProjects\\HomeWorks\\src\\ua\\dymohlo\\moduletwo\\baseList");
        fileIn.createNewFile();

        System.out.println("our groceries list: " + groceriesList(fileIn));
        System.out.println("filtered groceries: " + moreThanNeedParameter(groceriesList(fileIn)));
        System.out.println("total numbers of groceries:  " + totalNumbersOfGroceries(groceriesList(fileIn)));
        System.out.println("average price:  " + averagePrice(groceriesList(fileIn)));
        System.out.println("sorted groceries: " + descendingSorting(groceriesList(fileIn)));
        System.out.println("total price: " + totalGroceriesPrice(groceriesList(fileIn)));

        outPutInFile(fileIn);
    }

    private static List<Groceries> groceriesList(File file) throws IOException {
        List<Groceries> groceriesList = new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        String line;
        while ((line = randomAccessFile.readLine()) != null) {
            String[] ourLine = line.split("\\|");

            if (ourLine.length == 3) {
                String productName = ourLine[0].trim();
                int numberOfProduct = Integer.parseInt(ourLine[1].trim());
                double productPrice = Double.parseDouble(ourLine[2].trim());

                Groceries groceries = new Groceries(productName, numberOfProduct, productPrice);
                groceriesList.add(groceries);
            }
        }
        randomAccessFile.close();
        return groceriesList;
    }

    private static List<Groceries> moreThanNeedParameter(List<Groceries> list) {
        return list.stream().filter(l -> l.getNumberOfProduct() > 3).collect(Collectors.toList());
    }

    private static int totalNumbersOfGroceries(List<Groceries> list) {
        return list.stream().mapToInt(Groceries::getNumberOfProduct).sum();
    }

    private static double averagePrice(List<Groceries> list) {
        int totalNumbersOfGroceries = list.stream().mapToInt(Groceries::getNumberOfProduct).sum();
        double totalPrice = list.stream().mapToDouble(Groceries::getTotalPrice).sum();
        return (double) Math.round((totalPrice / totalNumbersOfGroceries) * 100) / 100;
    }

    private static List<Groceries> descendingSorting(List<Groceries> list) {
        Comparator<Groceries> priceComparator = Comparator.comparing(Groceries::getProductPrice).reversed();
        return list.stream().sorted(priceComparator).collect(Collectors.toList());
    }

    private static double totalGroceriesPrice(List<Groceries> list) {
        double totalPrice = list.stream().mapToDouble(Groceries::getTotalPrice).sum();
        int totalNumbersOfGroceries = list.stream().mapToInt(Groceries::getNumberOfProduct).sum();
        return (double) Math.round((totalPrice * totalNumbersOfGroceries) * 100) / 100;
    }

    private static void outPutInFile(File file) throws IOException {
        File fileOut = new File("C:\\Users\\DELL\\IdeaProjects\\HomeWorks\\src\\ua\\dymohlo\\moduletwo\\finalFile");
        fileOut.createNewFile();

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileOut, "rw");
        randomAccessFile.writeBytes(groceriesList(file).toString() + "\n");
        randomAccessFile.writeBytes(moreThanNeedParameter(groceriesList(file)).toString() + "\n");
        randomAccessFile.writeBytes(totalNumbersOfGroceries(groceriesList(file)) + "\n");
        randomAccessFile.writeBytes(averagePrice(groceriesList(file)) + "\n");
        randomAccessFile.writeBytes(descendingSorting(groceriesList(file)).toString() + "\n");
        randomAccessFile.writeBytes(String.valueOf(totalGroceriesPrice(groceriesList(file))));
        randomAccessFile.close();
    }
}