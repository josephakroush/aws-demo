package com.example.lambda;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HelloTest {
    @Test
    public void handleRequest() throws IOException {
        // Arrange
        Hello hello = new Hello();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        String expected = "{\"headers\":{},\"body\":\"{\\\"message\\\":\\\"this is the latest message\\\"}\",\"statusCode\":200}";

        // Act
        hello.handleRequest(stream);

        // Assert
        assertEquals(expected, stream.toString());
    }
}
