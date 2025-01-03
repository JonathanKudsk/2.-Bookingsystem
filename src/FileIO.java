import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    protected ArrayList<Electronic> allElectronics;
    protected ArrayList<Food> allFoods;
    private String filePathToClothes = "Data/Clothes";
    private String filePathToElectronics = "Data/Electronics";
    private String filePathToFoods = "Data/Foods";

    public ArrayList<Clothe> loadAllClothes() {
        ArrayList<Clothe> allClothes = new ArrayList<>();
        File file = new File(filePathToClothes);

        if (!file.exists()) {
            System.out.println("Brugerdatafil ikke fundet: " + filePathToClothes);
            return allClothes;
        }

        try (Scanner scanner = new Scanner(file)) {
            //scanner.nextLine(); // Skip header
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 5) {
                    String brandName = data[0].trim();
                    String type = data[1].trim();
                    String size = data[2].trim();
                    String color = data[3].trim();
                    String price = data[4].trim();
                    float priceInFloat = Float.parseFloat(price);
                    allClothes.add(new Clothe(brandName, type, size, color, priceInFloat));
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af brugerdata: " + e.getMessage());
        }
        return allClothes;
    }
}
