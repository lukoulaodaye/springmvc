package org.example.backendexamples.exception;

import lombok.*;

@EqualsAndHashCode(callSuper=true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class XException extends RuntimeException {
    private Code code;
    private int number;
    private String message;
}
