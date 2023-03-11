package org.example.interfaces;

import java.util.List;

public interface HtmlGeneratorInterface {
    void generate(List<? extends Content> contentList);
}
