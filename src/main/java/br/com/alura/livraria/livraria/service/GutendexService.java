package br.com.alura.livraria.livraria.service;


import br.com.alura.livraria.livraria.dto.GutendexResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {

    private final RestTemplate restTemplate = new RestTemplate();

    public GutendexResponse buscarLivroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        return restTemplate.getForObject(url, GutendexResponse.class);
    }
}
