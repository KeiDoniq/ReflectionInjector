package org.edu.vsu;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * Класс для получения properties из файла.
 */
class PropertyReader {
    private final String filePath;
    /**
     * Конструктор класса PropertyReader.
     *
     * @param filePath Путь к файлу.
     */
    PropertyReader(String filePath) {
        this.filePath = filePath;
    }
    /**
     * Метод для получения properties из файла.
     *
     * @return Объект Properties, содержащий properties из файла.
     * @throws RuntimeException если произошла ошибка ввода-вывода.
     */
    Properties getProperties(){
        Properties properties = null;
        try (FileReader reader = new FileReader(filePath)){
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
