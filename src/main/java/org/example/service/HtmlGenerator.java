package org.example.service;

import org.example.interfaces.Content;
import org.example.interfaces.HtmlGeneratorInterface;

import java.io.PrintWriter;
import java.util.List;

public class HtmlGenerator implements HtmlGeneratorInterface {

    private final PrintWriter writer;

    public HtmlGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void generate(List<? extends Content> contentList) {
        writer.println(
                """
                <html>
                    <head>
                        <meta charset=\"utf-8\">
                        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                        <link rel=\"stylesheet\" 
                        + href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                        + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"
                        + crossorigin=\"anonymous\">
                                    
                    </head>
                    <body>
                """);

        for (Content content : contentList) {
            String div =
                    """
                    <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                        <h4 class=\"card-header\">%s</h4>
                        <div class=\"card-body\">
                        <span class=\"card-text mt-3\" style=\"color: gray;\" > %s </span>
                            <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                            <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                        </div>
                    </div>
                    """;

            writer.println(String.format(div, content.title(), content.type(),
                    content.urlImage(), content.title(),
                    content.rating(), content.year()));
        }

        writer.println(
                """
                    </body>
                </html>
                """);
    }
}
