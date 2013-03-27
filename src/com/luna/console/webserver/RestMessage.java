package com.luna.console.webserver;

public class RestMessage {

    private String url;

    private Boolean isLastMessage;

    private Integer pageNumber;

    private String payload;

    private Long subsourceId;

    private String javaScriptObject;

    private Long deliveryTag;

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((deliveryTag == null) ? 0 : deliveryTag.hashCode());
        result = prime * result + ((isLastMessage == null) ? 0 : isLastMessage.hashCode());
        result = prime * result + ((javaScriptObject == null) ? 0 : javaScriptObject.hashCode());
        result = prime * result + ((pageNumber == null) ? 0 : pageNumber.hashCode());
        result = prime * result + ((payload == null) ? 0 : payload.hashCode());
        result = prime * result + ((subsourceId == null) ? 0 : subsourceId.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RestMessage other = (RestMessage) obj;
        if (deliveryTag == null) {
            if (other.deliveryTag != null)
                return false;
        } else if (!deliveryTag.equals(other.deliveryTag))
            return false;
        if (isLastMessage == null) {
            if (other.isLastMessage != null)
                return false;
        } else if (!isLastMessage.equals(other.isLastMessage))
            return false;
        if (javaScriptObject == null) {
            if (other.javaScriptObject != null)
                return false;
        } else if (!javaScriptObject.equals(other.javaScriptObject))
            return false;
        if (pageNumber == null) {
            if (other.pageNumber != null)
                return false;
        } else if (!pageNumber.equals(other.pageNumber))
            return false;
        if (payload == null) {
            if (other.payload != null)
                return false;
        } else if (!payload.equals(other.payload))
            return false;
        if (subsourceId == null) {
            if (other.subsourceId != null)
                return false;
        } else if (!subsourceId.equals(other.subsourceId))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    public Boolean getIsLastMessage() {

        return isLastMessage;
    }

    public void setIsLastMessage(Boolean isLastMessage) {

        this.isLastMessage = isLastMessage;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public Integer getPageNumber() {

        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {

        this.pageNumber = pageNumber;
    }

    public String getPayload() {

        return payload;
    }

    public void setPayload(String payload) {

        this.payload = payload;
    }

    public Long getDeliveryTag() {

        return deliveryTag;
    }

    public void setDeliveryTag(Long deliveryTag) {

        this.deliveryTag = deliveryTag;
    }

    public Long getSubsourceId() {

        return subsourceId;
    }

    public void setSubsourceId(Long subsourceId) {

        this.subsourceId = subsourceId;
    }

    public String getJavaScriptObject() {

        return javaScriptObject;
    }

    public void setJavaScriptObject(String javaScriptObject) {

        this.javaScriptObject = javaScriptObject;
    }

    @Override
    public String toString() {

        String result = String
                .format("{\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":%s,\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\",\"%s\":\"%s\"}",
                        "deliveryTag", deliveryTag, "isLastMessage", isLastMessage,
                        "javaScriptObject", javaScriptObject, "pageNumber", pageNumber, "payload",
                        payload, "subsourceId", subsourceId, "url", url);
        return result;
    }
}
