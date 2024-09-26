package org.taohansen.petfriends_almoxarifado.web.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}