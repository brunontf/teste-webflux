package tech.ada.teste.testewebflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "users")
public class User {
    
    @Id
    private String id;
    private String name;
    private int age;
    private double salary;
    private String department;
}
