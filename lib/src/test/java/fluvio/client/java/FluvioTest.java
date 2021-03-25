
package fluvio.client.java;

import org.junit.Test;
import static org.junit.Assert.*;
import fluvio.client.java.Fluvio;
import fluvio.client.java.TopicProducer;
import fluvio.client.java.PartitionConsumer;
import fluvio.client.java.PartitionConsumerStream;
import fluvio.client.java.Record;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FluvioTest {
    static {
        System.loadLibrary("fluvio_java");
    }

    @Test public void testFluvioConnect() throws Exception {
        Fluvio fluvio = Fluvio.connect();

        TopicProducer producer = fluvio.topic_producer(new String("simple-send"));
        PartitionConsumer consumer = fluvio.partition_consumer(new String("simple-send"), 0);
        PartitionConsumerStream stream = consumer.stream(0);

        for(int i = 0; i < 100; i++) {
            LocalDateTime in_date = LocalDateTime.now();
            String message = ("" + in_date);

            producer.send_record(message.getBytes(), 0);
            Record record = stream.next();

            String out = new String(record.value());
            LocalDateTime out_date = LocalDateTime.now();
            LocalDateTime parsed_date = LocalDateTime.parse(out);
            Duration duration = Duration.between(parsed_date, out_date);

            System.err.println("This message took " + duration.toNanos());

            assertTrue("send_record \"" + message + "\" is equal to \"" + out + "\"", out.equals(message));
        }
    }
}
