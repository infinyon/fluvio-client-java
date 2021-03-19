
package fluvio.client.java;

import org.junit.Test;
import static org.junit.Assert.*;
import fluvio.client.java.Fluvio;
//import com.fluvio.java.*;

public class FluvioTest {
    @Test public void testFluvioConnect() {
        Fluvio fluvio = Fluvio.connect();
    }
}
