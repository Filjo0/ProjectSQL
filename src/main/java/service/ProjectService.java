package service;

import blogic.HibernateUtil;
import dao.CrudDao;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectService implements CrudDao<Project, Integer> {

    @Override
    public void add(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(project);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Project> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();


        String getAll = "SELECT * FROM h2project.project";

        session.beginTransaction();
        Query<Project> query = session.createNativeQuery(getAll).addEntity(Project.class);
        List<Project> projectList = query.list();

        session.getTransaction().commit();
        session.close();

        return projectList;
    }

    @Override
    public Project getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String getId = "SELECT * FROM h2project.project where project_id = :project_id";
        session.beginTransaction();

        Query<Project> query = session.createNativeQuery(getId).addEntity(Project.class);
        query.setParameter("project_id", id);

        Project project = query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return project;
    }

    @Override
    public void update(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(project);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(project);

        session.getTransaction().commit();
        session.close();
    }
}
