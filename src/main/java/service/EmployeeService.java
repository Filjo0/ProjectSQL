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

        session.save(employee);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Employee> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();


        String getAll = "SELECT * FROM h2project.employee";

        session.beginTransaction();
        Query<Employee> query = session.createNativeQuery(getAll).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        session.getTransaction().commit();
        session.close();

        return employeeList;
    }

    @Override
    public Employee getById(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String getId = "SELECT * FROM h2project.employee where employee_id = :employee_id";
        session.beginTransaction();

        Query<Employee> query = session.createNativeQuery(getId).addEntity(Employee.class);
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

        session.update(employee);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(employee);

        session.getTransaction().commit();
        session.close();
    }
}
