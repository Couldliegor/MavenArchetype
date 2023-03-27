import Configuration.HibernateSessionFactoryUtil;
import Model.Employee;
import Service.EmployeeDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeDAOTest {
    @Mock
    EmployeeDAO employeeDAOS;
    @Mock
    HibernateSessionFactoryUtil hibernateSessionFactoryUtil;

    @Mock
    EmployeeDAO employeeDAO;
    private static final Employee EMPLOYEE_WHICH_IS_IN_DATABASE = new Employee(18, "Abdul", "Lolsl", "Male", 19, 1);
    private static final Employee EMPLOYEE_NEED_TO_RETURN_FROM_DATABASE = new Employee(11, "Zlata", "Morova", "Female", 19, 1);

    @Test
    public void shouldReturnEmployeeById() {
        assertEquals(employeeDAO.getEmployeeById(18), EMPLOYEE_WHICH_IS_IN_DATABASE);
    }

    @Test
    public void shouldTestMockito() {
        when(employeeDAO.getEmployeeById(12)).thenReturn(EMPLOYEE_NEED_TO_RETURN_FROM_DATABASE);
        assertEquals(employeeDAO.getEmployeeById(12), EMPLOYEE_NEED_TO_RETURN_FROM_DATABASE);
    }
}
