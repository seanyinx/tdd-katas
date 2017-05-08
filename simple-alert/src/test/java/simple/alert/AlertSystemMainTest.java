package simple.alert;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlertSystemMainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void alertOnProvidedCondition() {
        String rule = "(BELOW 5) CRITICAL";
        String data = "1,2,3,4,5,6,7";

        System.setIn(new ByteArrayInputStream(data.getBytes()));

        AlertSystemMain.main(new String[]{rule});

        String output = outputStream.toString().trim();

        assertThat(output, containsString("CRITICAL, CRITICAL, CRITICAL, CRITICAL, OK, OK, OK"));
    }
}
