package converter;

import converter.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.net.URI;
import java.util.Scanner;

public class ConverterAppl {
    public static void main(String []args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write your FROM currency: ");
        String fromCurrency = scanner.nextLine();

        System.out.print("Write amount of yours FROM currency: ");
        double amount = Double.parseDouble(scanner.nextLine());

        System.out.print("Write your TO currency: ");
        String toCurrency = scanner.nextLine();



        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apikey", "4QHV6P8Jh85woZ3ex6LCQA5UPukGQaAW");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.apilayer.com/fixer/convert")
                .queryParam("to", toCurrency)
                .queryParam("from", fromCurrency)
                .queryParam("amount", amount);

        URI url = builder.build().toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);

        ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);


        ResponseDto convertResponse = response.getBody();

        if (convertResponse != null) {
            System.out.println("Result = " + convertResponse.getResult() + toCurrency);
        } else {
            System.out.println("Conversion failed");
        }

}
}
