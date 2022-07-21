package com.example.crud_spring.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.example.crud_spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    int ID = 1;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getUserAll() {
       return entityManager.createQuery("SELECT users from User users",User.class).getResultList();
    }

    @Override
    public User getUserIndex(int index) {
        return entityManager.find(User.class,index);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(int id,User user){
        entityManager.createQuery("update User set name = :name,surname = :surname  where id = :id")
                .setParameter("name",user.getName())
                .setParameter("surname",user.getSurname())
                .setParameter("id",id)
                .executeUpdate();

    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }


}
