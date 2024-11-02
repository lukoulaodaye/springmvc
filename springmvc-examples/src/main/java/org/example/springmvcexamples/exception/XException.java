package org.example.springmvcexamples.exception;

import lombok.*;

@EqualsAndHashCode(callSuper=false)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XException extends RuntimeException {
    private Code code;
    private int number;
    private String message;
}
