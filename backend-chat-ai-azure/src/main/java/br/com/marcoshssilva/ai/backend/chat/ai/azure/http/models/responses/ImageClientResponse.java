package br.com.marcoshssilva.ai.backend.chat.ai.azure.http.models.responses;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class ImageClientResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String base64;
    private String url;
    private Date createdAt;

    public ImageClientResponse() {}

    public ImageClientResponse(String base64, String url, Date createdAt) {
        this.base64 = base64;
        this.url = url;
        this.createdAt = createdAt;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
