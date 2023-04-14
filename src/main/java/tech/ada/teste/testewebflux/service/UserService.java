package tech.ada.teste.testewebflux.service;

import java.util.Collections;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.ada.teste.testewebflux.model.User;
import tech.ada.teste.testewebflux.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final UserRepository userRepository;

    public Mono<User> createUser(User user){
        return userRepository.save(user);
    }

    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Mono<User> findById(String userId){
        return userRepository.findById(userId);
    }

    // public Mono<User> updateUser(String userId,  User user){
    //     return userRepository.findById(userId)
    //             .flatMap(dbUser -> {
    //                 dbUser.setAge(user.getAge());
    //                 dbUser.setSalary(user.getSalary());
    //                 return userRepository.save(dbUser);
    //             });
    // }

    public Mono<User> deleteUser(String userId){
        return userRepository.findById(userId)
                .flatMap(existingUser -> userRepository.delete(existingUser)
                        .then(Mono.just(existingUser)));
    }

    // public Flux<User> fetchUsers(String name) {
    //     Query query = new Query()
    //             .with(Sort
    //                     .by(Collections.singletonList(Sort.Order.asc("age")))
    //             );
    //     query.addCriteria(Criteria
    //             .where("name")
    //             .regex(name)
    //     );

    //     return reactiveMongoTemplate
    //             .find(query, User.class);
    // }
}