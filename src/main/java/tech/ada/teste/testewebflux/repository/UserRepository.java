package tech.ada.teste.testewebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import tech.ada.teste.testewebflux.model.User;

public interface UserRepository extends ReactiveMongoRepository<User,String> {
    
}
