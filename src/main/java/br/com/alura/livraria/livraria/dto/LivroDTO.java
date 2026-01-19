package br.com.alura.livraria.livraria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LivroDTO {

    private String title;

    private List<String> languages;

    @JsonProperty("download_count")
    private Integer downloadCout;

    private List<AutorDTO> authors;

    public String getTitle() {
        return title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Integer getDownloadCount() {
        return downloadCout;
    }

    public List<AutorDTO> getAuthors() {
        return authors;
    }
}
