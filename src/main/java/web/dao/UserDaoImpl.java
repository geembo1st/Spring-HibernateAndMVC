package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> showPeople() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User showUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = showUserById(id);
        if(user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void updateUser(Long id, User user) {
        entityManager.merge(user);
    }
}
