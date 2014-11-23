package com.epam.cdp;

import javax.ejb.Local;
import java.util.List;

/**
 * @author kisel.nikolay@gmail.com
 * @since 23.11.2014
 */
@Local
public interface PersonManager {

    public void savePerson(final Person person);

    public List getPersons();
}
