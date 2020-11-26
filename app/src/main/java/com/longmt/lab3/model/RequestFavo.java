
package com.longmt.lab3.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestFavo {

    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("api_key")
    @Expose
    private String apiKey;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("extras")
    @Expose
    private String extras;
    @SerializedName("per_page")
    @Expose
    private String perPage;
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("nojsoncallback")
    @Expose
    private Integer nojsoncallback;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getNojsoncallback() {
        return nojsoncallback;
    }

    public void setNojsoncallback(Integer nojsoncallback) {
        this.nojsoncallback = nojsoncallback;
    }

}
