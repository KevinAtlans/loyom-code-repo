package com.luna.console.code.reflection;

import java.lang.reflect.Field;

public class ReflectionMain {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // Reflection r = new Reflection();
        // User u = new User();
        // System.out.print(r.getProperty(u, "id").toString());

        User u = new User();

        Field[] fields = u.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (String.class.equals(f.getType())) {
                f.set(u, null);
                System.out.println(f.getName());
                System.out.println(f.getGenericType());
            }
        }
        System.out.println(u.getMail());
    }
}
