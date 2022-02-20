package ru.geekbrains;

/*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
 текст вместо числа), должно быть брошено исключение MyArrayDataException, с детализацией в какой
 именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
 и MyArrayDataException, и вывести результат расчета.*/

public class MainApp {
    public static int count;

    public static void main(String[] args) {

        String[][] arr = {
                {"1", "2", "3", "4,"},
                {"5", "6", "q", "8",},
                {"9", "w", "11", "12",},
                {"13", "14", "b", "16"}

        };
        try {
            checkArray(arr);
        } catch (MyArrayDataException | MyArraySizeException myArrayExceptions) {
            System.out.println(myArrayExceptions.getMessage());
        } finally {
            System.out.println("Результат расчета " + count);
        }
    }

    public static void checkArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length == 4) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4)
                    throw new MyArraySizeException("Массив другого размера...");
            }
            System.out.println("Массив верного размера");
        } else {
            throw new MyArraySizeException("Массив другого размера...");
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("Не число в ячейке массива arr[" + i + "][" + j + "]");

                }
            }
        }
    }
}

