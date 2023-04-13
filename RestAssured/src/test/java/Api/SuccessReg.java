package Api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Форма обертка для Post запроса регистрации
 */
@AllArgsConstructor
@Getter
public class SuccessReg {
    private Integer id;
    private String token;
}
