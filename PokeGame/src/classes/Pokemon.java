/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Map;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Miguel Matul <https://github.com/MigueMat4>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private String id;
    private String name;
    private float height;
    private float weight;
    Map<String, Object> sprites;

    public Pokemon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height / 10;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight / 10;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public Map<String, Object> getSprites(){
        return sprites;
    }
    
    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + name + '\'' +
                ", altura='" + height + '\'' +
                ", peso='" + weight + '\'' +
                ", sprites='" + sprites + '\'' +
                '}';
    }
}
