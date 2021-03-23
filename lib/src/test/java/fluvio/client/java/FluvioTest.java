
package fluvio.client.java;

import org.junit.Test;
import static org.junit.Assert.*;
import fluvio.client.java.Fluvio;
import fluvio.client.java.TopicProducer;
import fluvio.client.java.PartitionConsumer;
//import com.fluvio.java.*;

public class FluvioTest {
    @Test public void testFluvioConnect() throws Exception {
        Fluvio fluvio = Fluvio.connect();
        TopicProducer producer = fluvio.topic_producer(new String("baz"));
        PartitionConsumer consumer = fluvio.partition_consumer(new String("baz"), 1);
    }
}
