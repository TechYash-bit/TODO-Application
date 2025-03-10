package com.todo.todoApplication.services;

import com.todo.todoApplication.model.Task;
import com.todo.todoApplication.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    private final TaskRepo tr;

    public TodoServices(TaskRepo tr) {
        this.tr = tr;
    }

    public List<Task> geAllTask(){
        return tr.findAll();
    }
    public  void createTask(String title){
        Task task=new Task();
        task.setTitle(title);
        task.setComplete(false);

        tr.save(task);
       // return tr.findAll();
    }
    public void deleteTask(Long id) {
        tr.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task tk = tr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));

        tk.setComplete(!tk.isComplete()); // Toggles the completion status
        tr.save(tk);
    }

}
