
package fluvio.client.java;

import org.junit.Test;
import static org.junit.Assert.*;
import fluvio.client.java.Fluvio;
import fluvio.client.java.TopicProducer;
import fluvio.client.java.PartitionConsumer;
import fluvio.client.java.PartitionConsumerStream;
import fluvio.client.java.Record;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FluvioTest {
    @Test public void testFluvioConnect() throws Exception {
        Fluvio fluvio = Fluvio.connect();
        TopicProducer producer = fluvio.topic_producer(new String("simple-send"));
        PartitionConsumer consumer = fluvio.partition_consumer(new String("simple-send"), 0);
        PartitionConsumerStream stream = consumer.stream(0);

        for(int i = 0; i < 10; i++) {
            LocalDateTime date = LocalDateTime.now();
            String message = ("message: " + i + " at - " + date);
            producer.send_record(message.getBytes(), 0);
            Record record = stream.next();
            String out = new String(record.value());
            assertTrue("send_record \"" + message + "\" is equal to \"" + out + "\"", out.equals(message));
        }
    }
}
