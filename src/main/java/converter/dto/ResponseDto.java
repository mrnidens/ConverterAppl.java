package converter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private boolean success;
    private QueryDto query;
    private InfoDto info;
    private String date;
    private double result;

}
