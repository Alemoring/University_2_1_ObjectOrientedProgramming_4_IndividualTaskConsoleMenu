/*
 *
 *  Программа, помогающая подопрать самый дешёвый вариант товара,
 *  мониторящая данные о купленных товарах
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws Exception {
        // Загрузка из текстового файла массива разнообразных товаров
        System.out.print("Введите название файла, в котором хранятся или будут храниться данные о покупках: ");
        String filename = Menu.readLine();
        filename = Menu.readName(filename);
        ArrayList<Product> products = new ArrayList<>();
        Food[] foods = new Food[0];
        Milk[] milks = new Milk[0];
        Clothes[] clotheses = new Clothes[0];
        Technic[] technics = new Technic[0];
        if (Txt.nullFileOrNotNull()){
            products = Txt.readProductsFromFile();
            System.out.println("Данные успешно загружены");
        }
        //NullPointerException
        // Массив для хранения соответствия между значением и качеством
        String[] strings = new String[3];
        strings[0] = "Хорошо";
        strings[1] = "Нормально";
        strings[2] = "Плохо";
        while (Menu.getChoicetodo() != 5) {
            Menu.start();
            switch (Menu.getChoicetodo()) {
                case 1: // Добавить новую покупку
                    System.out.println("Введите тип покупки: ");
                    System.out.println("1) Еда");
                    System.out.println("2) Одежда");
                    System.out.println("3) Техника");
                    System.out.println("4) Молоко");
                    int id;
                    id = Menu.readValue(4);
                    Food food;
                    Milk milk;
                    Clothes clothes;
                    Technic technic;
                    System.out.print("Введите название товара: ");
                    String name = Menu.readLine();
                    Calendar date = Menu.setDate();
                    System.out.print("Введите цену покупки: ");
                    double price = Menu.readDoubleValue();
                    System.out.print("Введите адрес и название магазина, где был куплен товар: ");
                    String address = Menu.readLine();
                    System.out.println("Введите качество товара: ");
                    System.out.println("1) Хорошо");
                    System.out.println("2) Нормально");
                    System.out.println("3) Плохо");
                    short quality = (short) Menu.readValue(1);
                    quality -= 1;
                    boolean flag = false;
                    switch (id){
                        case 1: // Food
                            System.out.println("Хотите ли вы добавить информацию о сроке годности товара?");
                            System.out.println("1) Да");
                            System.out.println("2) Нет");
                            int choice = Menu.readValue(3);
                            if (choice == 1){
                                Calendar endDate = Menu.setDate();
                                food = new Food(name, date, price, address, quality, endDate);
                                Txt.writeFoodToFile(food);
                                flag = true;
                            }else {
                                food = new Food(name, date, price, address, quality);
                                Txt.writeProductToFile(food);
                                flag = true;
                            }
                            break;
                        case 2: // Clothes
                            clothes = new Clothes(name, date, price, address, quality);
                            Txt.writeProductToFile(clothes);
                        case 3: // Technic
                            System.out.println("Хотите ли вы добавить информацию о гарантии товара?");
                            System.out.println("1) Да");
                            System.out.println("2) Нет");
                            choice = Menu.readValue(3);
                            if (choice == 1){
                                System.out.print("Введите количество месяцев гарантии: ");
                                int guarantee = Menu.readValue(1);
                                technic = new Technic(name, date, price, address, quality, guarantee);
                                Txt.writeTechnicToFile(technic);
                                flag = true;
                            }else {
                                technic = new Technic(name, date, price, address, quality);
                                Txt.writeProductToFile(technic);
                                flag = true;
                            }
                            break;
                        case 4: // Milk
                            System.out.print("Введите жирность молока: ");
                            double fatContent = Menu.readDoubleValue();
                            System.out.println("Хотите ли вы добавить информацию о сроке годности товара?");
                            System.out.println("1) Да");
                            System.out.println("2) Нет");
                            choice = Menu.readValue(3);
                            if (choice == 1){
                                Calendar endDate = Menu.setDate();
                                milk = new Milk(name, date, price, address, quality, endDate, fatContent);
                                Txt.writeMilkToFile(milk, true);
                                flag = true;
                            }else {
                                milk = new Milk(name, date, price, address, quality, fatContent);
                                Txt.writeMilkToFile(milk, false);
                                flag = true;
                            }
                            break;
                    }
                    break;
                case 2: // Вывести 5 магазинов, где товар дешевле всего
                    System.out.println("Введите тип покупки: ");
                    System.out.println("1) Еда");
                    System.out.println("2) Одежда");
                    System.out.println("3) Техника");
                    System.out.println("4) Молоко");
                    int pid = Menu.readValue(4);
                    System.out.print("Введите название товара: ");
                    String pName = Menu.readLine();
                    if (pid == 1) {
                        if (foods != null) {
                            double[] prices = new double[foods.length];
                            for (int i = 0; i < prices.length; i++){
                                prices[i] = 1000000000;
                            }
                            int i = 0;
                            for (Food food1 : foods) {
                                if (food1.getName().toLowerCase().contains(pName.toLowerCase())){
                                    prices[i] = food1.getPrice();
                                    i++;
                                }
                            }
                            Arrays.sort(prices);
                            for (Food food1 : foods) {
                                if (food1.getPrice() == prices[0] || food1.getPrice() == prices[1] || food1.getPrice() == prices[2] || food1.getPrice() == prices[3] || food1.getPrice() == prices[4]){
                                    System.out.println("Товар " + food1.getName() + ", продаётся по цене " + food1.getPrice() + " рублей, по адресу " + food1.getAddress());
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    } else if (pid == 2) {
                        if(clotheses != null) {
                            double[] prices = new double[clotheses.length];
                            int i = 0;
                            for (Clothes clothes1 : clotheses) {
                                if (clothes1.getName().toLowerCase().contains(pName.toLowerCase())){
                                    prices[i] = clothes1.getPrice();
                                    i++;
                                }
                            }
                            Arrays.sort(prices);
                            for (Clothes clothes1 : clotheses) {
                                if (clothes1.getPrice() == prices[0] || clothes1.getPrice() == prices[1] || clothes1.getPrice() == prices[2] || clothes1.getPrice() == prices[3] || clothes1.getPrice() == prices[4]){
                                    System.out.println("Товар " + clothes1.getName() + ", продаётся по цене " + clothes1.getPrice() + " рублей, по адресу " + clothes1.getAddress());
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    }else if (pid == 3) {
                        if (technics != null) {
                            double[] prices = new double[technics.length];
                            int i = 0;
                            for (Technic technic1 : technics) {
                                if (technic1.getName().toLowerCase().contains(pName.toLowerCase())){
                                    prices[i] = technic1.getPrice();
                                    i++;
                                }
                            }
                            Arrays.sort(prices);
                            for (Technic technic1 : technics) {
                                if (technic1.getPrice() == prices[0] || technic1.getPrice() == prices[1] || technic1.getPrice() == prices[2] || technic1.getPrice() == prices[3] || technic1.getPrice() == prices[4]){
                                    System.out.println("Товар " + technic1.getName() + ", продаётся по цене " + technic1.getPrice() + " рублей, по адресу " + technic1.getAddress());
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    }else {
                        if (milks != null) {
                            double[] prices = new double[milks.length];
                            int i = 0;
                            for (Milk milk1 : milks) {
                                if (milk1.getName().toLowerCase().contains(pName.toLowerCase())){
                                    prices[i] = milk1.getPrice();
                                    i++;
                                }
                            }
                            Arrays.sort(prices);
                            for (Milk milk1 : milks) {
                                if (milk1.getPrice() == prices[0] || milk1.getPrice() == prices[1] || milk1.getPrice() == prices[2] || milk1.getPrice() == prices[3] || milk1.getPrice() == prices[4]){
                                    System.out.println("Товар " + milk1.getName() + ", продаётся по цене " + milk1.getPrice() + " рублей, по адресу " + milk1.getAddress());
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    }
                    break;
                case 3: // Вывести все магазины, где есть товар
                    System.out.println("Введите тип покупки: ");
                    System.out.println("1) Еда");
                    System.out.println("2) Одежда");
                    System.out.println("3) Техника");
                    System.out.println("4) Молоко");
                    int findid = Menu.readValue(4);
                    System.out.print("Введите название товара: ");
                    String findName = Menu.readLine();
                    if (findid == 1) {
                        if (foods != null) {
                            for (Food food1 : foods) {
                                if (food1.getName().toLowerCase().contains(findName.toLowerCase())){
                                    System.out.println(food1.getName() + " " + food1.getPurchaseDate().get(Calendar.YEAR) + " " + (food1.getPurchaseDate().get(Calendar.MONTH) + 1) + " " + food1.getPurchaseDate().get(Calendar.DATE) + " " + food1.getPrice() + " " + food1.getAddress() + " " + strings[food1.getQuality()]);
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    } else if (findid == 2) {
                        if(clotheses != null) {
                            for (Clothes clothes1 : clotheses) {
                                if (clothes1.getName().toLowerCase().contains(findName.toLowerCase())){
                                    System.out.println(clothes1.getName() + " " + clothes1.getPurchaseDate().get(Calendar.YEAR) + " " + (clothes1.getPurchaseDate().get(Calendar.MONTH) + 1) + " " + clothes1.getPurchaseDate().get(Calendar.DATE) + " " + clothes1.getPrice() + " " + clothes1.getAddress() + " " + strings[clothes1.getQuality()]);
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    }else if (findid == 3) {
                        if (technics != null) {
                            for (Technic technic1 : technics) {
                                if (technic1.getName().toLowerCase().contains(findName.toLowerCase())){
                                    System.out.println(technic1.getName() + " " + technic1.getPurchaseDate().get(Calendar.YEAR) + " " + (technic1.getPurchaseDate().get(Calendar.MONTH) + 1) + " " + technic1.getPurchaseDate().get(Calendar.DATE) + " " + technic1.getPrice() + " " + technic1.getAddress() + " " + strings[technic1.getQuality()]);
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    }else {
                        if (milks != null) {
                            for (Milk milk1 : milks) {
                                if (milk1.getName().toLowerCase().contains(findName.toLowerCase())){
                                    System.out.println(milk1.getName() + " " + milk1.getPurchaseDate().get(Calendar.YEAR) + " " + (milk1.getPurchaseDate().get(Calendar.MONTH) + 1) + " " + milk1.getPurchaseDate().get(Calendar.DATE) + " " + milk1.getPrice() + " " + milk1.getAddress() + " " + strings[milk1.getQuality()] + " " + milk1.getFatContent());
                                }
                            }
                        }else {
                            System.out.println("Список пуст");
                        }
                    }
                    break;
                case 4: // Узнать информацию о конкретном товаре
                    Menu.chooseFindCharacteristics(foods, clotheses, technics, milks);
                    break;
                case 5: // Выход
                    System.out.println("Производится выход из программы");
                    break;
                default:
                    System.out.println("Что-то не то");
                    break;
            }
        }
    }
}