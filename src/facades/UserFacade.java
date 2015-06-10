package facades;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Stateless(name="uFacade")
public class UserFacade {


    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;


    public User createUser(String email, String password, String name, String lastName) {
        if (findByEmail(email) != null)
            return null;

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setLastName(lastName);
        user.setRole("user");
        user.setCreatedAt(new Date(System.currentTimeMillis()));
        em.persist(user);
        return user;
    }


    public User findByEmail(String email) {
        List<User> userList = em.createNamedQuery("User.findUserByEmail", User.class).setParameter("email", email).getResultList();
        if (userList.isEmpty())
            return null;
        return userList.get(0);
    }






}
