package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import main.model.Task;

public class Storage {

  private static AtomicInteger currentId = new AtomicInteger(1);
  private static ConcurrentHashMap<Integer, Task> tasks = new ConcurrentHashMap<>();

  public static List<Task> getAllTasks() {
    ArrayList<Task> tasksList = new ArrayList<>();
    tasksList.addAll(tasks.values());
    return tasksList;
  }

  public static int addTask(Task task) {
    int id = currentId.getAndIncrement();
    task.setId(id);
    tasks.put(id, task);
    return id;
  }

  public static Task getTask(int taskId) {
    if (tasks.containsKey(taskId)) {
      return tasks.get(taskId);
    }
    return null;
  }

  public static Task deleteTask(int taskId) {
    if (tasks.containsKey(taskId)) {
      return tasks.remove(taskId);
    }
    return null;
  }

  public static void deleteTasks() {
    currentId.lazySet(1);
    tasks.clear();
  }

  public static Task putTask(int taskId, Task task) {
    if (tasks.containsKey(taskId)) {
      int id = taskId;
      task.setId(id);
      tasks.put(id, task);
      return task;

    }
    return null;
  }
}
