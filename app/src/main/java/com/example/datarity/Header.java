package com.example.datarity;

public class Header {

    private String nombre;
    private String image;

    public Header(String nombre,String image) {

        setNombre(nombre);
        setImage(image);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage(){return image;}
    public void setImage(String image){this.image = image;}
}
