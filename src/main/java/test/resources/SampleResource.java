package test.resources;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
            URL url = Resources.getResource("index.html");
            content = Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return content;
    }

}
