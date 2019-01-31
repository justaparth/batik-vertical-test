import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class VerticalTest {
    public static void main(String args[]) throws TranscoderException, FileNotFoundException {
        String fontFile = "src/main/resources/fonts/NotoSansJP-Bold.otf";
        File f = new File(fontFile);
        if (!f.exists()) {
            throw new IllegalStateException("Couldn't find font file at " + fontFile);
        }
        String svg =
                "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"400\" width=\"400\">\n"
                + "        <defs>"
                + "            <style>"
                + "             @font-face {"
                + "                    font-family: \"noto\";"
                + "                    src: url(\"" + fontFile + "\") format(\"opentype\");"
                + "             }"
                + "            </style>"
                + "            <path id=\"textpath\" d=\"M 20 20 Q 20 200 20 400\"></path>"
                + "        </defs>"
                + "        <text"
                + "            font-family=\"noto\""
                + "            font-size=\"40px\""
                + "            writing-mode=\"tb\""
                + "            >"
                + "            <textPath xlink:href=\"#textpath\">（「かな」）</textPath>"
                + "        </text>"
                + "    </svg>";

        PNGTranscoder pngTranscoder = new PNGTranscoder();
        pngTranscoder.addTranscodingHint(PNGTranscoder.KEY_AOI, new Rectangle(400, 400));
        File outputFile = new File("output_result.png");
        FileOutputStream stream = new FileOutputStream(outputFile);
        TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(svg.getBytes()));
        TranscoderOutput output = new TranscoderOutput(stream);
        pngTranscoder.transcode(input, output);
    }
}

