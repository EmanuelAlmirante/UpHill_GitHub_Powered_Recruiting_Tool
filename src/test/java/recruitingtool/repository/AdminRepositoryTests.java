package recruitingtool.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import recruitingtool.model.AdminModel;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AdminRepositoryTests {
    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void saveAdminSuccessfully() {
        // Arrange
        String username = "test";
        String password = "test";

        AdminModel adminModelToBeCreated =
                AdminModel.Builder.adminModelWith().withUsername(username).withPassword(password).build();

        // Act
        AdminModel adminModelCreated = adminRepository.save(adminModelToBeCreated);

        // Assert
        assertNotNull(adminModelCreated);
        assertEquals(username, adminModelCreated.getUserName());
        assertEquals(password, adminModelCreated.getPassword());
        assertNull(adminModelCreated.getToken());
    }

    @Test
    public void saveAdminWithTokenSuccessfully() {
        // Arrange
        String username = "test";
        String password = "test";
        String token = "o[pfjmdfniuw934oinkovnsdf";

        AdminModel adminModelToBeCreated =
                AdminModel.Builder.adminModelWith().withUsername(username).withPassword(password).withToken(token)
                                  .build();

        // Act
        AdminModel adminModelCreated = adminRepository.save(adminModelToBeCreated);

        // Assert
        assertNotNull(adminModelCreated);
        assertEquals(username, adminModelCreated.getUserName());
        assertEquals(password, adminModelCreated.getPassword());
        assertEquals(token, adminModelCreated.getToken());
    }
}
