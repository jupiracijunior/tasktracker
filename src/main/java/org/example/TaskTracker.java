package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "tasktracker", description = "Gerenciador de tarefas", subcommands = {Add.class, Update.class,
        Delete.class, MarkInProgress.class, MarkDone.class, ListTask.class})
public class TaskTracker implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new TaskTracker()).execute(args);
        System.exit(exitCode);
    }
}

@Command(name = "add", description = "Adiciona uma nova tarefa")
class Add implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;
    private static FileOutputStream outStream;

    @Parameters(index = "0", description = "Descricao da nova tarefa")
    private String description;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        mt.add(this.description); // Adiciona uma tarefa

        /* Salva as alteracoes */
        outStream = new FileOutputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json");
        outStream.write(mapper.writeValueAsString(mt).getBytes());
        outStream.flush();
        outStream.close();

        return 0;
    }
}

@Command(name = "update", description = "Atualiza uma tarefa")
class Update implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;
    private static FileOutputStream outStream;

    @Parameters(index = "0", description = "id da tarefa")
    private int id;

    @Parameters(index = "1", description = "Descricao da nova tarefa")
    private String description;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        mt.update(this.id, this.description); // Atualiza a descricao da tarefa

        /* Salva as alteracoes */
        outStream = new FileOutputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json");
        outStream.write(mapper.writeValueAsString(mt).getBytes());
        outStream.flush();
        outStream.close();

        return 0;
    }
}

@Command(name = "delete", description = "Deleta uma tarefa")
class Delete implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;
    private static FileOutputStream outStream;

    @Parameters(index = "0", description = "id da tarefa")
    private int id;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        mt.delete(this.id); // Deleta a tarefa

        /* Salva as alteracoes */
        outStream = new FileOutputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json");
        outStream.write(mapper.writeValueAsString(mt).getBytes());
        outStream.flush();
        outStream.close();

        return 0;
    }
}

@Command(name = "mark-in-progress", description = "Marca uma tarefa como em progresso")
class MarkInProgress implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;
    private static FileOutputStream outStream;

    @Parameters(index = "0", description = "id da tarefa")
    private int id;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        mt.mark_in_progress(this.id); // Marca a tarefa como em progresso

        /* Salva as alteracoes */
        outStream = new FileOutputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json");
        outStream.write(mapper.writeValueAsString(mt).getBytes());
        outStream.flush();
        outStream.close();

        return 0;
    }
}

@Command(name = "mark-done", description = "Marca uma tarefa como concluida")
class MarkDone implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;
    private static FileOutputStream outStream;

    @Parameters(index = "0", description = "id da tarefa")
    private int id;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        mt.mark_done(this.id); // Marca a tarefa como concluida

        /* Salva as alteracoes */
        outStream = new FileOutputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json");
        outStream.write(mapper.writeValueAsString(mt).getBytes());
        outStream.flush();
        outStream.close();

        return 0;
    }
}

@Command(name = "list", description = "Lista todas as tarefas", subcommands = {ListTodo.class, ListInProgress.class, ListDone.class})
class ListTask implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        System.out.println(mt.list_all()); // Exibe todas as tarefas

        return 0;
    }
}

/* =============== */
@Command(name = "todo", description = "lista tarefas a fazer")
class ListTodo implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        System.out.println(mt.list_todo()); // Exibe as tarefas pendentes

        return 0;
    }
}

@Command(name = "in-progress", description = "lista tarefas em progresso")
class ListInProgress implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        System.out.println(mt.list_in_progress()); // Exibe as tarefas em progresso

        return 0;
    }
}

@Command(name = "done", description = "lista tarefas concluidas")
class ListDone implements Callable<Integer> {
    private static ManagerTask mt;
    private static ObjectMapper mapper;

    @Override
    public Integer call() throws Exception {
        mapper = new ObjectMapper();
        Path path = Path.of("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\");

        // Cria o storage.json caso não exista
        if (!Files.isDirectory(path)) {
            Files.createDirectory(path);
            Files.createFile(Path.of(path.toString() + "\\storage.json"));
        }

        // Le o storage.json
        mt = mapper.readValue(new FileInputStream("C:\\Users\\jupir\\AppData\\Roaming\\TaskTracker\\storage.json"),
                ManagerTask.class);

        System.out.println(mt.list_done()); // Exibe as tarefas concluidas

        return 0;
    }
}


class ManagerTask {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    // Adiciona novas tarefas
    public void add(String description) {
        this.getTasks().add(new Task(this.getTasks().size() + 1, description));
    }

    // Atualiza a descricao da tarefa
    public void update(int id, String description) {
        this.getTasks().get(id - 1).setDescription(description);
        this.getTasks().get(id - 1).setUpdateAt(LocalDate.now().toString());
    }

    // Remove uma tarefa
    public void delete(int id) {
        this.getTasks().remove(this.getTasks().get(id - 1));

        // ajusta os ids para corresponderem ao ArrayList
        for (int i=id;i<this.getTasks().size()+1;i++) {
            this.getTasks().get(id - 1).setId(this.getTasks().get(id - 1).getId() - 1);
        }
    }

    /* Atualiza o status */
    public void mark_todo(int id) {
        this.getTasks().get(id - 1).setStatus("todo");
    }

    public void mark_in_progress(int id) {
        this.getTasks().get(id - 1).setStatus("in-progress");
    }

    public void mark_done(int id) {
        this.getTasks().get(id - 1).setStatus("done");
    }

    // Busca tarefas por id
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

    // Lista as tarefas
    public String list_all() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            list.append(task.getId() + " " + task.getDescription() + "\n");
        }

        return list.toString();
    }

    public String list_in_progress() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            if (task.getStatus().equals("in-progress")) {
                list.append(task.getId() + " " + task.getDescription() + "\n");
            }
        }

        return list.toString();
    }

    public String list_todo() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            if (task.getStatus().equals("todo")) {
                list.append(task.getId() + " " + task.getDescription() + "\n");
            }
        }

        return list.toString();
    }

    public String list_done() {
        StringBuilder list = new StringBuilder();
        Iterator<Task> iterator = this.getTasks().iterator();;
        Task task = null;

        while (iterator.hasNext()) {
            task = iterator.next();
            if (task.getStatus().equals("done")) {
                list.append(task.getId() + " " + task.getDescription() + "\n");
            }
        }

        return list.toString();
    }

    // Getters
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Setters
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}

class Task {
    private int id;
    private String description;
    private String status;
    private String createAt;
    private String updateAt;

    public Task() {

    }

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createAt = LocalDate.now().toString();
        this.updateAt = LocalDate.now().toString();
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    // Getters
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