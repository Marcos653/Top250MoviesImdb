package org.example.interfaces;

import java.io.IOException;

public interface ApiClient {
    String getApi() throws IOException, InterruptedException;
}
