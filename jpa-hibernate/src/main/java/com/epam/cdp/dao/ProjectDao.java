package com.epam.cdp.dao;

import com.epam.cdp.domain.Project;

/**
 * @author kisel.nikolay@gmail.com
 * @since 08.12.2014
 */
public interface ProjectDao {

    public void create(Project project);

    public Project findById(Long id);

    public void remove(Project project);

    public void update(Project project);
}
