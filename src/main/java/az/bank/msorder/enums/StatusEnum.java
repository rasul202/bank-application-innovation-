package az.bank.msorder.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {

    ACTIVE(1) , DE_ACTIVE(0);

    final Integer status;

}
