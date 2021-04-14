
package com.example;

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

public class Simple {
    public static void main(String[] args) throws Exception {
        Fluvio fluvio = Fluvio.connect();

        TopicProducer producer = fluvio.topic_producer(new String("simple-example"));
        PartitionConsumer consumer = fluvio.partition_consumer(new String("simple-example"), 0);
        producer.send_record(new String("").getBytes(), 0);
        PartitionConsumerStream stream = consumer.stream(Offset.beginning());
        stream.next();

        for(int i = 0; i < 100; i++) {
            LocalDateTime in_date = LocalDateTime.now();
            String message = ("" + in_date);

            producer.send_record(message.getBytes(), 0);
            Record record = stream.next();

            String out = new String(record.value());
            LocalDateTime out_date = LocalDateTime.now();
            LocalDateTime parsed_date = LocalDateTime.parse(out);
            Duration duration = Duration.between(parsed_date, out_date);

            System.err.println("This message took " + duration.toMillis() + "ms");
            if (!out.equals(message)) {
                throw new Exception("Messages dont match! " + out + " doesnt equal " + message);
            }
        }
    }
}
