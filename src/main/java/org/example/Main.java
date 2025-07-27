package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private static ManagerTask mt;
    private static ObjectMapper mapper;

    public static void main(String[] args) throws IOException {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"), ManagerTask.class);



    }
}

class ManagerTask {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public Task searchID(int id) {
        Iterator<Task> iterator = this.getTasks().iterator();

        Task currentTask;
        while (iterator.hasNext()) {
            currentTask = iterator.next();
            if (currentTask.getId() == id) {
                return currentTask;
            }
        }

        System.out.println("Nenhuma correspondencia encontrada");

        return null;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}

class Task {
    private int id = 3;
    private String description;
    private String status;
    private String createAt;
    private String updateAt;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}