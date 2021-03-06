package com.geodan.labs.geofencer.domain;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Created by janb on 16-11-2014.
 */
public class MessageStatus {

    private UUID messageId;

    private DateTime lastStatusChange = DateTime.now();

    private StatusType status;

    /**
     * <p>A translatable code with the message.</p>
     */
    private String code;

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }

    public DateTime getLastStatusChange() {
        return lastStatusChange;
    }

    public void setLastStatusChange(DateTime lastStatusChange) {
        this.lastStatusChange = lastStatusChange;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageStatus)) return false;

        MessageStatus that = (MessageStatus) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (lastStatusChange != null ? !lastStatusChange.equals(that.lastStatusChange) : that.lastStatusChange != null)
            return false;
        if (!messageId.equals(that.messageId)) return false;
        if (status != that.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId.hashCode();
        result = 31 * result + (lastStatusChange != null ? lastStatusChange.hashCode() : 0);
        result = 31 * result + status.hashCode();
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return status.toString();
    }

    public static class Builder {

        private StatusType status;

        private Builder() {
        }

        public static Builder messageStatus() {
            return new Builder();
        }

        public Builder withStatus(StatusType status) {
            this.status = status;
            return this;
        }

        public MessageStatus build() {
            return new MessageStatus();
        }
    }
}
