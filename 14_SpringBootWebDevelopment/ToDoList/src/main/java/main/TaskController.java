package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private TaskRepository taskRepository;

  @GetMapping()
  public List<Task> list() {
    Iterable<Task> taskIterable = taskRepository.findAll();
    ArrayList<Task> tasks = new ArrayList<>();
    for (Task task : taskIterable) {
      tasks.add(task);
    }
    return tasks;
  }

  @PostMapping()
  public int addTask(Task task) {

    Task newTask = taskRepository.save(task);
    return newTask.getId();
  }

  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable int id) {

    Optional<Task> optionalTask = taskRepository.findById(id);
    if (!optionalTask.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Task> deleteTask(@PathVariable int id) {
    Optional<Task> optionalTask = taskRepository.findById(id);
    if (optionalTask.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    taskRepository.delete(optionalTask.get());
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> updateTask(@PathVariable int id,
      @Valid @RequestBody Task task) {
    Optional<Task> optionalTask = taskRepository.findById(id);
    if (optionalTask.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    Task updatedTask = optionalTask.get();
    updatedTask.setName(task.getName());
    updatedTask.setDescription(task.getDescription());
    taskRepository.save(updatedTask);

    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
  }

  @DeleteMapping()
  public ResponseEntity<Task> delete() {
    taskRepository.deleteAll();
    return new ResponseEntity(HttpStatus.OK);
  }

}

