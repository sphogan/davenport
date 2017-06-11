package rocks.davenport.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

public class HtmlNewlineEscaper {
    private static final Escaper HTML_ESCAPER =
            Escapers.builder()
                    .addEscape('"', "&quot;")
                    // Note: "&apos;" is not defined in HTML 4.01.
                    .addEscape('&', "&amp;")
                    .addEscape('<', "&lt;")
                    .addEscape('>', "&gt;")
                    .addEscape('\n', "<br>")
                    .addEscape('\'', "&#39;")
                    .build();

    public static Escaper escaper() {
        return HTML_ESCAPER;
    }
}
