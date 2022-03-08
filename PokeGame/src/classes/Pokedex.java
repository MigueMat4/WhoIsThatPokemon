/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Miguel Matul <https://github.com/MigueMat4>
 */

// clase que conecta a la API y obtiene los datos del pokémon buscado
public class Pokedex {
    private static final String POKEMON_API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private int numeroPokemon;
    
    public Pokedex(){
        numeroPokemon = 1;
    }
        
    public Pokemon buscarPokemon() throws IOException, InterruptedException{
        numeroPokemon = (int) Math.floor(Math.random() * 151 + 1);
        System.out.println("Conectando a la API...");
        // código para conectarse a la API y descargar los datos.
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("Accept", "application/json")
                    .uri(URI.create(POKEMON_API_URL+numeroPokemon))
                    .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("¡Conexión exitosa! Descargando datos...");
        ObjectMapper mapper = new ObjectMapper();
        // obtener los datos del pokémon en el objeto correspondiente
        return mapper.readValue(response.body(), Pokemon.class);
    }
}
