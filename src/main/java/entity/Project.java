package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + project_id +
                ", title='" + title + '\'' +
                '}';
    }
}
