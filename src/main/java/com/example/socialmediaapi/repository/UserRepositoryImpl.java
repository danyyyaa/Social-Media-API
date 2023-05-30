package com.example.socialmediaapi.repository;

import com.example.socialmediaapi.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Optional<User> createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return Optional.of(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User userFromDb = session.get(User.class, id);
        session.getTransaction().commit();
        return Optional.ofNullable(userFromDb);
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User", User.class);
            return Optional.ofNullable(query.list());
        }
    }
}
