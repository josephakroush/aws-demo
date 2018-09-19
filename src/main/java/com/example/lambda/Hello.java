package com.example.lambda;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Hello {

    public void handleRequest(OutputStream outputStream) throws IOException {
        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "this is the latest message on 9-18");

        JSONObject responseJson = new JSONObject();
        responseJson.put("statusCode", 200);
        responseJson.put("headers", new JSONObject());
        responseJson.put("body", responseBody.toString());

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}
