import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static private Scanner scanner = new Scanner(System.in);
    static private int choicetodo = -1;
    static private int choiceid = -1;
    public static int readChoice(){
        scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Пожалуйстаа вводите только существующие пункты меню ;)");
            readed = readChoice();
        }
        return readed;
    }
    public static int readValue(){
        scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Введено неверное значение :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readValue();
        }
        return readed;
    }
    public static double readDoubleValue(){
        scanner = new Scanner(System.in);
        double readed = -1;
        try {
            readed = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Введено неверное значение :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readDoubleValue();
        }
        return readed;
    }
    public static int readYesOrNot(){
        scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
            if(readed != 1 && readed != 2){
                readed = readYesOrNot();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Введено неверное значение :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readYesOrNot();
        }
        return readed;
    }
    public static String readLine(){
        scanner = new Scanner(System.in);
        String readed = "";
        try {
            readed = scanner.nextLine();
        }
        catch (NumberFormatException e){
            System.out.println("Что-то пошло не так :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readLine();
        }
        return readed;
    }
    public static String readName(String name){
        boolean flag = Txt.setFilename(name);
        while(!flag){
            System.out.print("Такого файла не существует, введите существующий файл: ");
            name = readLine();
            flag = Txt.setFilename(name);
        }
        return name;
    }
    public static int readId(){
        scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
            if(readed > 4 || readed < 1){
                readed = readValue();
            }
        }
        catch (NumberFormatException e){
            System.out.println("Введено неверное значение :(");
            System.out.print("Попробуйте снова, у вас всё получится: ");
            readed = readValue();
        }
        return readed;
    }

     public static void start() {
        System.out.println("Приветствую!");
        System.out.println("Данное приложение поможет мониторить цены на товары и не только, что будем делать?");
        System.out.println("1) Добавить новую покупку");
        System.out.println("2) Вывести 5 магазинов, где товар дешевле всего");
        System.out.println("3) Вывести все магазины, где есть товар");
        System.out.println("4) Узнать информацию о конкретном товаре");
        System.out.println("5) Вывести все товары, которые есть в магазине (Разрабатывается)");
        System.out.println("5) Выйти из программы");
        choicetodo = readChoice();
    }

     public static void chooseFindCharacteristics(Food[] foods, Clothes[] clotheses, Technic[] technics, Milk[] milks) throws IOException { // Если выбрали 4 пункт в начале
        choiceid = -1;
        do{
            System.out.println("Введите тип покупки: ");
            System.out.println("1) Еда");
            System.out.println("2) Одежда");
            System.out.println("3) Техника");
            System.out.println("4) Молоко");
            choiceid = Menu.readId();
            String findName;
            switch (choiceid){
                case 1: // Еда
                    System.out.print("Введите название товара, у которого хотите узнать срок годности: ");
                    findName = Menu.readLine();
                    if (foods != null) {
                        for (Food food1 : foods) {
                            if (food1.getName().toLowerCase().contains(findName.toLowerCase())){
                                System.out.println("У товара " + food1.getName() + ", который стоит " + food1.getPrice() + " рублей, купленного по адресу " + food1.getAddress() + ", срок годности до " + food1.getStorageLife().get(Calendar.YEAR) + " года " + (food1.getStorageLife().get(Calendar.MONTH) + 1) + " месяца " + food1.getStorageLife().get(Calendar.DATE) + " дня");
                            }
                        }
                    }else {
                        System.out.println("Список пуст");
                    }
                    choiceid = 5;
                    break;
                case 2: // Одежда
                    System.out.println("К сожалению, у одежды ещё нет уникальной характеристики");
                    choiceid = 5;
                    break;
                case 3: // Техника
                    System.out.print("Введите название товара, у которого хотите узнать срок гарантии: ");
                    findName = Menu.readLine();
                    if (technics != null) {
                        for (Technic technic1: technics) {
                            if (technic1.getName().toLowerCase().contains(findName.toLowerCase())){
                                System.out.println("У товара " + technic1.getName() + ", который стоит " + technic1.getPrice() + " рублей, купленного по адресу " + technic1.getAddress() + ", " + technic1.getPurchaseDate().get(Calendar.YEAR) + " года " + (technic1.getPurchaseDate().get(Calendar.MONTH) + 1) + " месяца " + technic1.getPurchaseDate().get(Calendar.DATE) + " числа " + ", гарантия " + technic1.getGuarantee() + " месяцев");
                            }
                        }
                    }else {
                        System.out.println("Список пуст");
                    }
                    choiceid = 5;
                    break;
                case 4: // Молоко
                    System.out.print("Введите название товара, у которого хотите узнать срок годности: ");
                    findName = Menu.readLine();
                    if (milks != null) {
                        for (Milk milk1 : milks) {
                            if (milk1.getName().toLowerCase().contains(findName.toLowerCase())){
                                System.out.println("У товара " + milk1.getName() + ", который стоит " + milk1.getPrice() + " рублей, купленного по адресу " + milk1.getAddress() + ", срок годности до " + milk1.getStorageLife().get(Calendar.YEAR) + " года " + (milk1.getStorageLife().get(Calendar.MONTH) + 1) + " месяца " + milk1.getStorageLife().get(Calendar.DATE) + " дня");
                            }
                        }
                    }else {
                        System.out.println("Список пуст");
                    }
                    choiceid = 5;
                    break;
            }
        }while (choiceid != 5);
    }
     public static int getChoicetodo(){
        return choicetodo;
    }

     public static int getChoiceid() {
        return choiceid;
    }

}