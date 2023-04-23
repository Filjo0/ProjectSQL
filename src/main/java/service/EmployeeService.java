package service;

import blogic.HibernateUtil;
import dao.CrudDao;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements CrudDao<Employee, Integer> {

    @Override
    public void add(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(employee);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Employee> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();


        String getAll = "SELECT * FROM h2project.employee";

        session.beginTransaction();
        Query<Employee> query = session.createNativeQuery(getAll, Employee.class);
        List<Employee> employeeList = query.list();

        session.getTransaction().commit();
        session.close();

        return employeeList;
    }

    @Override
    public Employee getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String getId = "SELECT * FROM h2project.employee where employee_id = :employee_id";
        session.beginTransaction();

        Query<Employee> query = session.createNativeQuery(getId, Employee.class);
        query.setParameter("employee_id", id);

        Employee employee = query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    @Override
    public void update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.merge(employee);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.remove(employee);

        session.getTransaction().commit();
        session.close();
    }
}
