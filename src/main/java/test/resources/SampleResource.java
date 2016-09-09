package test.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class SampleResource {

    /**
     * リクエストを処理するサンプル
     * 
     * @return htmlコンテンツ
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String showHellowWorld() {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("index.html").toURI())),
                    StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException urie) {
            urie.printStackTrace();
        }

        return content;
    }

}
