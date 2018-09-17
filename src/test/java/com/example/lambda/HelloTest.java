package com.example.lambda;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HelloTest {
    @Test
    public void helloTestHappyPath() throws IOException {
        // Arrange
        Hello hello = new Hello();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        String expected = "{\"headers\":{},\"body\":\"{\\\"message\\\":\\\"New item created\\\"}\",\"statusCode\":200}";

        // Act
        hello.handleRequest(stream);

        // Assert
        assertEquals(expected, stream.toString());
    }
}
