package com.infinyon.fluvio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FluvioTest {

    @Test
    public void testFluvioConnect() {
        Exception thrown = assertThrows(Exception.class, Fluvio::connect);
        assertThat(thrown.getMessage(), anyOf(
            containsString(
                "Socket(Io(Os { code: 61, kind: ConnectionRefused, message: \"Connection refused\" }))"),
            containsString("ClientConfig(NoActiveProfile)")
        ));
    }
}
