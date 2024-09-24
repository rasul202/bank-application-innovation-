package az.bank.msorder.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class NotFoundException extends RuntimeException {

    Integer status;
    LocalDateTime occurredAt;

    public NotFoundException(String message , Integer status , LocalDateTime occurredAt ){
        super(message);
        this.status = status;
        this.occurredAt = occurredAt;
    }


}
