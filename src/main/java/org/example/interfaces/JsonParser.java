package org.example.interfaces;

import java.util.List;

public interface JsonParser {
    List<? extends Content> parse();
}
