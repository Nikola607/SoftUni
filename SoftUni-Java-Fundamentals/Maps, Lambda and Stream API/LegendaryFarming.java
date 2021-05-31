package AssociativeArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> valueMaterials = new HashMap<>();
        Map<String, Integer> trashMaterials = new TreeMap<>();

        valueMaterials.put("shards", 0);
        valueMaterials.put("fragments", 0);
        valueMaterials.put("motes", 0);

        boolean isObtained = false;

        while (!isObtained) {
            String[] command = scan.nextLine().split(" ");

            for (int i = 0; i < command.length; i +=2) {
                int number = Integer.parseInt(command[i]);
                String material = command[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    valueMaterials.putIfAbsent(material, 0);

                    valueMaterials.put(material, valueMaterials.get(material) + number);

                    if (valueMaterials.get(material) >= 250) {
                        isObtained = true;

                        valueMaterials.put(material, valueMaterials.get(material) - 250);

                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }

                        break;
                    }

                } else {
                    trashMaterials.putIfAbsent(material, 0);

                    trashMaterials.put(material, trashMaterials.get(material) + number);
                }
            }
        }

        valueMaterials.entrySet().
                stream().
                sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if(result==0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        trashMaterials.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
