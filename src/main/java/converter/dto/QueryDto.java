package converter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryDto {
    private String from;
    private String to;
    private double amount;
}
