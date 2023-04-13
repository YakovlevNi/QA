package Api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Форма обертка для JSON
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserData {

    public Integer id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
