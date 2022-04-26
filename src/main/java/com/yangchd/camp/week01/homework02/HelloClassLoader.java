package com.yangchd.camp.week01.homework02;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) throws Exception {
        HelloClassLoader helloClassLoader = new HelloClassLoader();
        Class<?> className = helloClassLoader.findClass("Hello");
        Object instance = className.newInstance();
        Method method = className.getDeclaredMethod("hello");
        method.invoke(instance);

        /*new HelloClassLoader().findClass("week01.Hello").newInstance();*/
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name + ".xlass");
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            byte[] decodeBytes = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                decodeBytes[i] = (byte)(255 - bytes[i]);
            }
            return defineClass(name, decodeBytes, 0, decodeBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*@Override
    protected Class<?> findClass(String name) {
        String baseStr = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAg8Y2xpbml0PgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABYMABcAGAEAGEhlbGxvIENsYXNzIEluaXRpYWxpemVkIQcAGQwAGgAbAQAMd2VlazAxL0hlbGxvAQAQamF2YS9sYW5nL09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAMACAALAAgAAQAJAAAAJQACAAAAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABQAIAAYAAQAMAAAAAgAN";
        byte[] bytes = Base64.getDecoder().decode(baseStr);
        return defineClass(name, bytes, 0, bytes.length);
    }*/
}
