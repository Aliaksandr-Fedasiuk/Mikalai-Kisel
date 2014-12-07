package com.epam.cdp.dao;

import com.epam.cdp.domain.Project;
import com.epam.cdp.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * @author kisel.nikolay@gmail.com
 * @since 08.12.2014
 */
public class ProjectDaoImpl implements ProjectDao {

    private EntityManager em = HibernateUtil.getEm();

    @Override
    public void create(Project project) {
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
    }

    @Override
    public Project findById(Long id) {
        return em.find(Project.class, id);
    }

    @Override
    public void remove(Project project) {
        em.getTransaction().begin();
        Project mergedProject = em.merge(project);
        em.remove(mergedProject);
        em.getTransaction().commit();
    }

    @Override
    public void update(Project project) {
        em.getTransaction().begin();
        em.merge(project);
        em.getTransaction().commit();
    }
}
