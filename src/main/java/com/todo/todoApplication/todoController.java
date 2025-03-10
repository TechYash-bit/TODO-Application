package com.todo.todoApplication;

import com.todo.todoApplication.model.Task;
import com.todo.todoApplication.services.TodoServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class todoController {

    private final TodoServices td;

    public todoController(TodoServices td) {
        this.td = td;
    }



    @PostMapping
    public String createTask(@RequestParam String title){

        //System.out.println(title);
      td.createTask(title);
        return "redirect:/";
    }
    @GetMapping
    public String home(Model model){
        List<Task> tasks=td.geAllTask();
        model.addAttribute("tasks",tasks);
        return "index";
    }
    @GetMapping("/tasks/{id}/delete")
    public String delete(@PathVariable Long id) {
        td.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/tasks/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        td.toggleTask(id);
        return "redirect:/";
    }
}
