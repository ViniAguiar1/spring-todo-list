package br.com.viniciusaguiar.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;  // Importando o UUID

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;
    
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
    
    @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        System.out.println("Chegou no controller " + request.getAttribute("idUser"));
        var idUser = request.getAttribute("idUser");

        // Convertendo idUser para UUID
        taskModel.setIdUser((UUID) idUser);  

        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
