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
        entityManager.createNativeQuery("update testdb.users set name = '" + user.getName() + "',surname = '" + user.getSurname() +"' where id =" + id + ";").executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(getUserIndex(id));

    }


}
