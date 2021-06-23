package Reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Field[] fields = RichSoilLand.class.getDeclaredFields();
		List<Field> list = new ArrayList<>();

		String commands = scan.nextLine();

		while (!commands.equals("HARVEST")){
			if(commands.equals("all")){
				list.addAll(Arrays.asList(fields));
			}else{
				String neededModifier = commands;
				Arrays.stream(fields)
						.filter(f -> Modifier.toString(f.getModifiers()).equals(neededModifier))
						.forEach(list::add);
			}
			commands = scan.nextLine();
		}

		for(Field field : list){
			System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
		}
	}
}
