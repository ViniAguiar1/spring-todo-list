package br.com.viniciusaguiar.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;


/**
 * Tipos de acesso:
 * public: todos podem acessar
 * protected: somente classes do mesmo pacote e subclasses podem acessar
 * default: somente classes do mesmo pacote podem acessar
 * private: somente a própria classe pode acessar
 */

 @RestController
 @RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;    
    /**
     * Tipos
     * String: texto
     * int: número inteiro
     * long: número inteiro longo
     * double: número decimal
     * float: número decimal
     * boolean: verdadeiro ou falso
     * char: caractere
     * List: lista
     * Set: conjunto
     * Map: mapa
     * Date: data
     * LocalDate: data
     * LocalDateTime: data e hora
     * LocalTime: hora
     * void: vazio
     */
    @PostMapping("/")
     public ResponseEntity create(@RequestBody UserModel userModel){
        
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null){
            System.out.println("Usuário já existe");
            // Mensagem de erro
            // Status Code (requisição inválida)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
