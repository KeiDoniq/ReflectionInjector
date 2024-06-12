package org.edu.vsu;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс для инициализации зависимостей с помощью аннотации @AutoInjectable.
 */
class Injector {
    /**
     * Конструктор класса Injector, который принимает путь к файлу свойств.
     *
     * @param pathToProperties Путь к файлу свойств.
     */
    Injector(String pathToProperties) {
        this.propertyReader = new PropertyReader(pathToProperties);
        this.properties = propertyReader.getProperties();
    }
    /**
     * Конструктор класса Injector по умолчанию, использующий путь к файлу
     * "src/main/resources/config.properties".
     */
    Injector() {
        this.propertyReader = new PropertyReader("src/main/resources/config.properties");
        this.properties = propertyReader.getProperties();
    }
    private Properties properties;
    private PropertyReader propertyReader;
    /**
     * Метод для инъекции зависимостей в переданный объект.
     *
     * @param <T>        Тип объекта.
     * @param someObject Объект, в который будут инъецироваться зависимости.
     * @return Объект с зависимостями.
     * @throws RuntimeException если произошла ошибка при создании или установке зависимостей.
     */
    <T> T inject(T someObject) {
        Class<?> someClass = someObject.getClass();
        for (Field field : someClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String interfaceType = field.getType().getName();
                String implementationClass = properties.getProperty(interfaceType);
                field.setAccessible(true);
                try {
                    field.set(someObject, Class.forName(implementationClass).newInstance());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return someObject;
    }
}
