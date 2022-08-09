package br.com.acrani.springbootmongodb.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public class StandartError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING
            ,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
            ,timezone = "GMT")
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private Map<String, String> message;
    private String path;

    public StandartError(LocalDateTime timestamp, Integer status, String error, Map<String, String> message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
