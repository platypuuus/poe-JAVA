import fr.aelion.helpers.exceptions.StudentException;
import fr.aelion.models.Student;
import fr.aelion.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {
    StudentRepository studentRepository;

    @BeforeEach
    public void setup() throws StudentException, SQLException {
        studentRepository = new StudentRepository(Student.class);
    }

    @Test
    @DisplayName("Student list should have 100 element")
    public void studentInstanciationTest() throws SQLException {
        List<Student> students = studentRepository.findAll();
        assertEquals(students.size(), 100);
    }

    @Test
    @DisplayName("First student of the list should be Adam Balthazar 78")
    public void firstStudentMustMatch() throws SQLException {
        List<Student> students = studentRepository.findAll();
        Student student = students.get(0);
        assertAll(
                () -> assertEquals("Adam", student.getLastName()),
                () -> assertEquals("Balthazar", student.getFirstName()),
                () -> assertEquals(78, student.getId())
        );
    }

    @Test
    @DisplayName("should return Aubert Swassane 71")
    public void studentByLoginTest() throws SQLException {
        Student student = studentRepository.findByLoginAndPassword("Aubert.Swassane", "MK1qVF6WBCzVn6lPgJNf");
        assertAll(
                () -> assertEquals("Aubert", student.getLastName()),
                () -> assertEquals("Swassane", student.getFirstName()),
                () -> assertEquals(71, student.getId())
        );
    }

   /** @Test
    @DisplayName("should return student from model")
    public void shouldReturnTableName() {
        assertEquals("student", studentRepository.getTableName());
    }

    @Test
    @DisplayName("should return 'student s'")
    public void shouldGiveAliasedTableName() {
        assertEquals("student s", studentRepository.getAliasedTableName());
    }

    @Test
    @DisplayName("Should list all attributes")
    void shouldListAllAttributes() {
        String[] expectedFields = {"email", "firstName", "id", "lastName", "login", "password", "phoneNumber"};
        String[] fields = studentRepository.getFields();
        Arrays.sort(fields);
        assertTrue(Arrays.equals(expectedFields, fields));
    }

    @Test
    @DisplayName("Should return a comma separate list of column names")
    void shouldReturnCommaSeparatedList() {
        String expected = "s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number";
        assertEquals(expected, studentRepository.getCommaSeparatedColumns());
    }

    @Test
    @DisplayName("Should return a full SELECT query")
    void shouldReturnSelectQuery() {
        String expected = "SELECT s.email,s.first_name,s.id,s.last_name,s.login,s.password,s.phone_number FROM student s;";
        assertEquals(expected, studentRepository.getSelectQuery());
    }*/
}
