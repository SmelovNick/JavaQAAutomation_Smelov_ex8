import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    StringHelper stringHelper;

    @BeforeEach
    void localSetup(){
        stringHelper = new StringHelper("Generic text");
        System.out.println("Project structure is very primitive...well, i dont'know what to paste here(\nHowever, this text is shown and it means that BeforeEach Annotation works correctly");
    }

    @AfterEach
    void localTeardown(){
        stringHelper = null;
        System.out.println("Project structure is very primitive...well, i dont'know what to paste here(\nHowever, this text is shown and it means that AfterEach Annotation works correctly");
    }
}
