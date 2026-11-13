/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.nio.file.*;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class Storage {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static final Path PATH_DIR = Path.of("dat");

    public static void save(Object obj, String fileName) {
        try {
            Files.createDirectories(PATH_DIR);
            Path file = PATH_DIR.resolve(fileName);
            mapper.writeValue(file.toFile(), obj);
            System.out.println("Saved to: " + file.toAbsolutePath());
        } catch (java.io.IOException e) {
            throw new RuntimeException("Failed to save " + fileName, e);
        }
    }

    public static <T> T load(String fileName, Class<T> type) {
        Path file = PATH_DIR.resolve(fileName);
        if (!Files.exists(file)) {return null;}
        return mapper.readValue(file.toFile(), type);
    }

    public static <T> T load(String fileName, TypeReference<T> type) {
        Path file = PATH_DIR.resolve(fileName);
        if (!Files.exists(file)) {return null;}
        return mapper.readValue(file.toFile(), type);
    }
}
