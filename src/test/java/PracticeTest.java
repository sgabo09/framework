import hu.selenium.BrowserManager;
import hu.selenium.TestUserGenerator.TestUser;
import hu.selenium.TestUserGenerator.TestUserGenerator;
import hu.selenium.TestUserGenerator.TestUserRepository;
import org.junit.AfterClass;
import org.junit.Test;

import java.sql.SQLException;

public class PracticeTest {

    @Test
    public void login() throws SQLException, ClassNotFoundException {
        TestUserRepository tum = new TestUserRepository();
        TestUserGenerator tug = new TestUserGenerator(tum);

        TestUser testUser = tug.generateTestUserWithValidAddress();

        System.out.println(testUser.firstName);
        System.out.println(testUser.lastName);
        System.out.println(testUser.address);
        System.out.println(testUser.city);
        System.out.println(testUser.district);
        System.out.println(testUser.country);
        System.out.println(testUser.email);
        System.out.println(testUser.gender);
    }

    @AfterClass
    public static void cleanUp(){
        BrowserManager.closeBrowsers();
    }
}