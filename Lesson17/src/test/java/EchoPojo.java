import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EchoPojo {
    @JsonProperty("data")
    private String data;
    @JsonProperty("foo1")
    private String foo1;
    @JsonProperty("foo2")
    private String foo2;
    @JsonProperty("x-request-start")
    public String xReqStart;
    @JsonProperty("x-forwarded-proto")
    public String xForwProto;
    @JsonProperty("x-forwarded-port")
    private String xForwPort;
    @JsonProperty("host")
    private String host;
    @JsonProperty("x-amzn-trace-id")
    private String xATI;
    @JsonProperty("user-agent")
    private String userAgent;
    @JsonProperty("accept")
    private String accept;
    @JsonProperty("cache-control")
    private String cacheControl;
    @JsonProperty("postman-token")
    private String postmToken;
    @JsonProperty("accept-encoding")
    private String acceptEncod;
    @JsonProperty("content-length")
    private String contLength;
    @JsonProperty("content-type")
    private String contType;
    @JsonProperty("cookie")
    private String cookie;
    @JsonProperty("url")
    private String url;
    @JsonProperty("json")
    private String json;

    /*          список геттеров для копипасты
         getFoo1(), getFoo2(), getHost(), getXForwProto(),
         getXForwPort(), getContType(), getUserAgent(), getAccept(),
         getAcceptEncod(), getCacheControl(), getContLength(), getJson(),
         getCookie(), getPostmToken(), getXATI(), getUrl(), getData(), getXReqStart(),   */

    public List<String> getReqHeaders() {
        return List.of(getHost(), getXForwProto(), getXForwPort(),
                getContType(), getAccept(), getUserAgent(), getAcceptEncod());
    }

    public List<String> postRTReqHeaders() {
        return List.of(getHost(), getContLength(),
                getXForwProto(), getXForwPort(), getContType(),
                getAccept(), getUserAgent(), getAcceptEncod());
    }

    public List<String> postFDReqHeaders() {
        return List.of(getHost(), getContLength(),
                getXForwProto(), getXForwPort(), getAccept(),
                getContType(), getUserAgent(), getAcceptEncod());
    }

    public List<String> putReqHeaders() {
        return List.of(getHost(), getContLength(),
                getXForwProto(), getXForwPort(),
                getAccept(), getContType(),
                getUserAgent(), getAcceptEncod());
    }

    public List<String> patchReqHeaders() {
        return List.of(getHost(), getContLength(),
                getXForwProto(), getXForwPort(),
                getAccept(), getContType(),
                getUserAgent(), getAcceptEncod());
    }

    public List<String> deleteReqHeaders() {
        return List.of(getHost(), getContLength(),
                getXForwProto(), getXForwPort(),
                getAccept(), getContType(),
                getUserAgent(), getAcceptEncod());
    }

}
