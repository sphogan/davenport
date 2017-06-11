package rocks.davenport.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

public class NewlineToHtmlBreak {
    private static final Escaper HTML_ESCAPER =
            Escapers.builder()
                    .addEscape('\n', "<br>")
                    .build();

    public static Escaper newlineToBreaks() {
        return HTML_ESCAPER;
    }
}
