
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
        Fluvio fluvio = Fluvio.connect();

        TopicProducer producer = fluvio.topic_producer(new String("simple-send"));
        PartitionConsumer consumer = fluvio.partition_consumer(new String("simple-send"), 0);
        PartitionConsumerStream stream = consumer.stream(Offset.beginning());

        for(int i = 0; i < 10; i++) {
            LocalDateTime in_date = LocalDateTime.now();
            String message = ("" + in_date);

            producer.send_record(message.getBytes(), 0);
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
