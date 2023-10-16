package br.com.eduardaperboire.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // Retorno tanto de sucesso quanto de erro
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

// Modificadores
// public = qualquer um pode acessar a classe
// private = restrição maior/permissão de alguns atributos/ pode ser acessado apenas pela própria classe
// protected = quando tá mesma estrutura do pacote que tem acesso

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired // Gerencia o ciclo de vida(instanciar...) do repositório
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");//
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword((passwordHashred));

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
    
}
