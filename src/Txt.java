import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Txt {
    private static File file;
    private static String name;

    public static ArrayList<Product> readProductsFromFile() {
        try {
            if(file.length() != 0){
                ArrayList<Product> products = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int k= 0; // Количество товаров
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    //System.out.println(values.length); Product = 8
                    //System.out.println(values[values.length - 1]); Product = quality
                    k++;
                }
                reader.close();
                reader = new BufferedReader(new FileReader(file));
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    String productName = values[1].replace("_", " ");
                    Calendar purchaseDate = Calendar.getInstance();
                    purchaseDate.set(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                    double price = Double.parseDouble(values[5]);
                    String address = values[6].replace("_", " ");
                    short quality = Short.parseShort(values[7]);
                    String comment = values[8].replace("_", " ");
                    switch (id){
                        case 1: // Food
                            Calendar storageLife = Calendar.getInstance();
                            purchaseDate.set(Integer.parseInt(values[9]), Integer.parseInt(values[10]), Integer.parseInt(values[11]));
                            Food food = new Food(productName, purchaseDate, price, address, quality, storageLife);
                            products.add(food);
                            break;
                        case 2: // Clothes
                            Clothes cloth = new Clothes(productName, purchaseDate, price, address, quality);
                            products.add(cloth);
                            break;
                        case 3: // Technic
                            int guarantee = Integer.parseInt(values[9]);
                            Technic technic = new Technic(productName, purchaseDate, price, address, quality, guarantee);
                            products.add(technic);
                            break;
                        case 4: // Milk
                            Calendar mStorageLife = Calendar.getInstance();
                            purchaseDate.set(Integer.parseInt(values[9]), Integer.parseInt(values[10]), Integer.parseInt(values[11]));
                            double fatContent = Double.parseDouble(values[12]);
                            Milk milk = new Milk(productName, purchaseDate, price, address, quality, mStorageLife, fatContent);
                            products.add(milk);
                            break;
                    }
                    i++;
                }
                reader.close();
                return products;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
            return null;
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
            return null;
        }
        return null;
    }
    public static Clothes[] readClothesFromFile() {
        try {
            if(file.length() != 0){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int k= 0; // Количество товаров
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    //System.out.println(values.length); Product = 8
                    //System.out.println(values[values.length - 1]); Product = quality
                    int id = Integer.parseInt(values[0]);
                    if(id != 2){
                        continue;
                    }
                    k++;
                }
                reader.close();
                reader = new BufferedReader(new FileReader(file));
                Clothes[] clothes = new Clothes[k];
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 2){
                        continue;
                    }
                    String productName = values[1].replace("_", " ");
                    Calendar purchaseDate = Calendar.getInstance();
                    purchaseDate.set(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                    double price = Double.parseDouble(values[5]);
                    String address = values[6].replace("_", " ");
                    short quality = Short.parseShort(values[7]);
                    clothes[i] = new Clothes(productName, purchaseDate, price, address, quality);
                    i++;
                }
                reader.close();
                return clothes;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
            return null;
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
            return null;
        }
        return null;
    }
    public static Food[] readFoodFromFile() {
        try {
            if(file.length() != 0){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int k= 0; // Количество товаров
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 1){
                        continue;
                    }
                    k++;
                }
                reader.close();
                reader = new BufferedReader(new FileReader(file));
                Food[] food = new Food[k];
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 1){
                        continue;
                    }
                    String productName = values[1].replace("_", " ");
                    Calendar purchaseDate = Calendar.getInstance();
                    purchaseDate.set(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                    double price = Double.parseDouble(values[5]);
                    String address = values[6].replace("_", " ");
                    short quality = Short.parseShort(values[7]);
                    if (values.length > 8){
                        Calendar endDate = Calendar.getInstance();
                        endDate.set(Integer.parseInt(values[8]), Integer.parseInt(values[9]), Integer.parseInt(values[10]));
                        food[i] = new Food(productName, purchaseDate, price, address, endDate, quality);
                    }else {
                        food[i] = new Food(productName, purchaseDate, price, address, quality);
                    }
                    i++;
                }
                reader.close();
                return food;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
            return null;
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
            return null;
        }
        return null;
    }
    public static Milk[] readMilkFromFile() {
        try {
            if(file.length() != 0){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int k= 0; // Количество товаров
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 4){
                        continue;
                    }
                    k++;
                }
                reader.close();
                reader = new BufferedReader(new FileReader(file));
                Milk[] milk = new Milk[k];
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 4){
                        continue;
                    }
                    String productName = values[1].replace("_", " ");
                    Calendar purchaseDate = Calendar.getInstance();
                    purchaseDate.set(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                    double price = Double.parseDouble(values[5]);
                    String address = values[6].replace("_", " ");
                    short quality = Short.parseShort(values[7]);
                    double fatContent = Double.parseDouble(values[8]);
                    if (values.length > 9){
                        Calendar endDate = Calendar.getInstance();
                        endDate.set(Integer.parseInt(values[9]), Integer.parseInt(values[10]), Integer.parseInt(values[11]));
                        milk[i] = new Milk(productName, purchaseDate, price, address, endDate, quality, fatContent);
                    }else {
                        milk[i] = new Milk(productName, purchaseDate, price, address, quality, fatContent);
                    }
                    i++;
                }
                reader.close();
                return milk;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
            return null;
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
            return null;
        }
        return null;
    }
    public static Technic[] readTechnicFromFile() {
        try {
            if(file.length() != 0){
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                int k= 0; // Количество товаров
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 3){
                        continue;
                    }
                    k++;
                }
                reader.close();
                reader = new BufferedReader(new FileReader(file));
                Technic[] technic = new Technic[k];
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split(" ");
                    int id = Integer.parseInt(values[0]);
                    if(id != 3){
                        continue;
                    }
                    String productName = values[1].replace("_", " ");
                    Calendar purchaseDate = Calendar.getInstance();
                    purchaseDate.set(Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                    double price = Double.parseDouble(values[5]);
                    String address = values[6].replace("_", " ");
                    short quality = Short.parseShort(values[7]);
                    if (values.length > 8){
                        int guarantee = Integer.parseInt(values[8]);
                        technic[i] = new Technic(productName, purchaseDate, price, address, quality, guarantee);
                    }else {
                        technic[i] = new Technic(productName, purchaseDate, price, address, quality);
                    }
                    i++;
                }
                reader.close();
                return technic;
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
            return null;
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
            return null;
        }
        return null;
    }
    public static void writeProductToFile(Product product) {
        try {
            FileWriter writer = new FileWriter(name, true);
            writer.write(product.getId() + " " + product.getName().replace(" ", "_") + " " + product.getPurchaseDate().get(Calendar.YEAR) + " " + product.getPurchaseDate().get(Calendar.MONTH) + " " + product.getPurchaseDate().get(Calendar.DATE) + " " + product.getPrice() + " " + product.getAddress().replace(" ", "_") + " " + product.getQuality() + "\n");
            writer.close();
            System.out.println("Данные успешно добавлены");
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
    }
    public static void writeFoodToFile(Food food) {
        try {
            FileWriter writer = new FileWriter(name, true);
            writer.write(food.getId() + " " + food.getName().replace(" ", "_") + " " + food.getPurchaseDate().get(Calendar.YEAR) + " " + food.getPurchaseDate().get(Calendar.MONTH) + " " + food.getPurchaseDate().get(Calendar.DATE) + " " + food.getPrice() + " " + food.getAddress().replace(" ", "_") + " " + food.getQuality() + " " + food.getStorageLife().get(Calendar.YEAR) + " " + food.getStorageLife().get(Calendar.MONTH) + " " + food.getStorageLife().get(Calendar.DATE) + "\n");
            writer.close();
            System.out.println("Данные успешно добавлены");
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
    }
    public static void writeMilkToFile(Milk milk, boolean isStorageLife) {
        try {
            FileWriter writer = new FileWriter(name, true);
            if(isStorageLife){
                writer.write(milk.getId() + " " + milk.getName().replace(" ", "_") + " " + milk.getPurchaseDate().get(Calendar.YEAR) + " " + milk.getPurchaseDate().get(Calendar.MONTH) + " " + milk.getPurchaseDate().get(Calendar.DATE) + " " + milk.getPrice() + " " + milk.getAddress().replace(" ", "_") + " " + milk.getQuality() + " " + milk.getFatContent() + " " + milk.getStorageLife().get(Calendar.YEAR) + " " + milk.getStorageLife().get(Calendar.MONTH) + " " + milk.getStorageLife().get(Calendar.DATE) + '\n');
            }else{
                writer.write(milk.getId() + " " + milk.getName().replace(" ", "_") + " " + milk.getPurchaseDate().get(Calendar.YEAR) + " " + milk.getPurchaseDate().get(Calendar.MONTH) + " " + milk.getPurchaseDate().get(Calendar.DATE) + " " + milk.getPrice() + " " + milk.getAddress().replace(" ", "_") + " " + milk.getQuality() + " " + milk.getFatContent() + "\n");
            }
            writer.close();
            System.out.println("Данные успешно добавлены");
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
    }
    public static void writeTechnicToFile(Technic technic) {
        try {
            FileWriter writer = new FileWriter(name, true);
            writer.write(technic.getId() + " " + technic.getName().replace(" ", "_") + " " + technic.getPurchaseDate().get(Calendar.YEAR) + " " + technic.getPurchaseDate().get(Calendar.MONTH) + " " + technic.getPurchaseDate().get(Calendar.DATE) + " " + technic.getPrice() + " " + technic.getAddress().replace(" ", "_") + " " + technic.getQuality() + " " + technic.getGuarantee() + "\n");
            writer.close();
            System.out.println("Данные успешно добавлены");
        }
        catch (FileNotFoundException e){
            System.out.println("Такого файла не существует");
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так");
        }
    }

    public static boolean setFilename(String name){
        name += ".txt";
        file = new File(name);
        Txt.name = name;
        try {
            if (file.exists()){
                System.out.println("Файл существует");
            } else{
                file.createNewFile();
                System.out.println("Файл успешно создан");
            }
            return true;
        }catch (IOException e){
            System.out.println("Ошибка при создании файла");
            return false;
        }
    }
    public static boolean nullFileOrNotNull(){
        if (file.length() == 0){
            System.out.println("Файл пустой");
            return false;
        }
        else {
            System.out.println("Файл содержит данные");
            return true;
        }
    }
}