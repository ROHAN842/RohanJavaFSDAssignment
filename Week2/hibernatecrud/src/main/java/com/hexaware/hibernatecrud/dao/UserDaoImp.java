package com.hexaware.hibernatecrud.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hexaware.hibernatecrud.HibernateUtil;
import com.hexaware.hibernatecrud.entity.User;


public class UserDaoImp implements IUserDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

    @Override
    public boolean insertUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction txn = session.beginTransaction();
            session.saveOrUpdate(user);
 // saveOrUpdate method instead of just save to handle both insert and update scenarios.
  // This way, if the userID is not set in the User object, Hibernate will treat it as a new entity and 
  //insert it with a new auto-incremented userID. If the userID is set, Hibernate will treat it as an existing entity and update it.          
            txn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction txn = session.beginTransaction();
            session.update(user);
            txn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUserById(int userID) {
        try (Session session = sessionFactory.openSession()) {
            Transaction txn = session.beginTransaction();
            User user = session.get(User.class, userID);
            if (user != null) {
                session.delete(user);
                txn.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    @Override
    public User selectUserByName(String userName) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createNamedQuery("selectUserByName");
            query.setParameter("name", userName);
            User user = (User) query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            // Handle the case where no user is found with the given name
            return null;
        }
    }


    @Override
    public List<User> selectAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


