package service;

import blogic.HibernateUtil;
import dao.CrudDao;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressService implements CrudDao<Address, Integer> {

    @Override
    public void add(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(address);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Address> getAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();


        String getAll = "SELECT * FROM h2project.address";

        session.beginTransaction();

        Query<Address> query = session.createNativeQuery(getAll, Address.class);
        List<Address> addressList = query.list();

        session.getTransaction().commit();
        session.close();

        return addressList;
    }

    @Override
    public Address getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String getId = "SELECT * FROM h2project.address where address_id = :address_id";

        session.beginTransaction();

        Query<Address> query = session.createNativeQuery(getId, Address.class);
        query.setParameter("address_id", id);

        Address address = query.getSingleResult();

        session.getTransaction().commit();
        session.close();


        return address;
    }

    @Override
    public void update(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(address);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.remove(address);

        session.getTransaction().commit();
        session.close();
    }
}
