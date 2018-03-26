import org.junit.Test;

public class PracticeTest {

    ConfigReader cr = new ConfigReader();
    @Test
    public void main(){
        System.out.println("Implicitly wait: " + cr.getImplicitlyWait());
        System.out.println("Defualt wait: " + cr.getDefaultWait());
    }
}
