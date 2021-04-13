
package com.infinyon.fluvio;

import org.junit.Test;
import static org.junit.Assert.*;
import com.infinyon.fluvio.Fluvio;
import com.infinyon.fluvio.TopicProducer;
import com.infinyon.fluvio.PartitionConsumer;
import com.infinyon.fluvio.PartitionConsumerStream;
import com.infinyon.fluvio.Record;
import com.infinyon.fluvio.Offset;
import java.util.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FluvioTest {
    static {
        System.loadLibrary("fluvio_java");
    }

    @Test public void testFluvioConnect() throws Exception {
        System.err.println("RUNNING UNIT TESTS");
        Fluvio fluvio = Fluvio.connect();

        String topic = new String("simple-send");
        System.err.println("STARTING STREAM ON TOPIC: " + topic);

        TopicProducer producer = fluvio.topic_producer(topic);
        PartitionConsumer consumer = fluvio.partition_consumer(topic, 0);

        // consumer.stream hangs until there's something in it so we must put
        // something in it before we create the stream
        producer.send_record(new String("").getBytes(), 0);
        PartitionConsumerStream stream = consumer.stream(Offset.beginning());

        // We must consume the single record as it'll make all the tests be one
        // off from what's expected.
        stream.next();
        System.err.println("STARTED STREAM ON TOPIC: " + topic);

        for(int i = 0; i < 10; i++) {
            LocalDateTime in_date = LocalDateTime.now();
            String message = ("" + in_date);

            producer.send_record(message.getBytes(), 0);
            System.err.println("SEND MESSAGE: " + message);

            Record record = stream.next();

            String out = new String(record.value());
            LocalDateTime out_date = LocalDateTime.now();
            LocalDateTime parsed_date = LocalDateTime.parse(out);
            Duration duration = Duration.between(parsed_date, out_date);

            System.err.println("This message took " + duration.toMillis() + "ms");

            assertTrue("send_record \"" + message + "\" is equal to \"" + out + "\"", out.equals(message));
        }
    }
}
