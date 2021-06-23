package Reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Method[]methods = BlackBoxInt.class.getDeclaredMethods();

        String input = scan.nextLine();
        while (!input.equals("END")){
            String[] commands = input.split("_");

            String action = commands[0];
            int num = Integer.parseInt(commands[1]);

            Method method = Arrays.stream(methods).filter(m->m.getName().equals(action)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt, num);

            Field field = BlackBoxInt.class.getDeclaredField("innerValue");

            field.setAccessible(true);

            input = scan.nextLine();
            System.out.println(field.get(blackBoxInt));
        }
    }
}
