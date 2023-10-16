package br.com.eduardaperboire.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
// import jakarta.persistence.Column; - Definir o nome da coluna, caso ela seja diferente do nome do atributo
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    // atributos de uma classe
    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
