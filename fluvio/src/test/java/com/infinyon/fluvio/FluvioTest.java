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

    @Test public void testFluvioConnect() {
        try {
            Fluvio fluvio = Fluvio.connect();
        } catch (Exception e) {
            System.err.println("exception: " + e);
            assertTrue(e.getMessage().equals("FlvSocketError(IoError(Os { code: 111, kind: ConnectionRefused, message: \"Connection refused\" }))"));
        }
    }
}
