package com.erichiroshi.picpay.service.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NotificationException extends PicPayException {
    private static final long serialVersionUID = 1L;

    private final String detail;

    public NotificationException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.GATEWAY_TIMEOUT);

        pb.setTitle("Notification error");
        pb.setDetail(detail);
        pb.setProperty("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        return pb;
    }

}
