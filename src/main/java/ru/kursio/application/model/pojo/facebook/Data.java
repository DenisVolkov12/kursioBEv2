
package ru.kursio.application.model.pojo.facebook;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "height",
    "is_silhouette",
    "url",
    "width"
})
public class Data implements Serializable
{

    @JsonProperty("height")
    private Integer height;
    @JsonProperty("is_silhouette")
    private Integer isSilhouette;
    @JsonProperty("url")
    private String url;
    @JsonProperty("width")
    private Integer width;
    private final static long serialVersionUID = 8456317944126040715L;

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("is_silhouette")
    public Integer getIsSilhouette() {
        return isSilhouette;
    }

    @JsonProperty("is_silhouette")
    public void setIsSilhouette(Integer isSilhouette) {
        this.isSilhouette = isSilhouette;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

}
