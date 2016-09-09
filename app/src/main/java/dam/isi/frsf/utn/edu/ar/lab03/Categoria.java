/*
 * Copyright (c) 2016 Daniel Campodonico; Emiliano Gioria; Lucas Moretti.
 * This file is part of Lab03.
 *
 * Lab03 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Lab03 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Lab03.  If not, see <http://www.gnu.org/licenses/>.
 */

package dam.isi.frsf.utn.edu.ar.lab03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dam.isi.frsf.utn.edu.ar.lab03.Trabajo;

public class Categoria implements Serializable {
    private Integer id;
    private String descripcion;
    private List<Trabajo> trabajos;

    public Categoria(){
        this.trabajos=new ArrayList<Trabajo>();
    }

    public Categoria(Integer id,String desc){
        this();
        this.id = id;
        this.descripcion = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Trabajo> getTrabajo() {
        return trabajos;
    }

    public void setTrabajo(List<Trabajo> trabajos) {
        this.trabajos = trabajos;
    }

    public void addTrabajo(Trabajo t){
        this.trabajos.add(t);
    }

    public static final Categoria[] CATEGORIAS_MOCK= new Categoria[]{
            new Categoria(1,"Arquitecto"),
            new Categoria(2,"Desarrollador"),
            new Categoria(3, "Tester"),
            new Categoria(4,"Analista"),
            new Categoria(5,"Mobile Developer")
    };

}
