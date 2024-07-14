package az.edu.orient.handler;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExceptionResponse {
    private int code;
    private String message;
    private List<FieldException> fieldErrors;
}
