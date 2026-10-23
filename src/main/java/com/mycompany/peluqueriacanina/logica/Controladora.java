package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {

ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String nombreDuenio, String celDuenio, String observaciones, String alergico, String atencionEspecial){
       
        //creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
       mascota.setNombre(nombreMascota);
       mascota.setRaza(raza);
       mascota.setColor(color);
       mascota.setAlergico(alergico);
       mascota.setAtencionEspecial(atencionEspecial);
       mascota.setObservaciones(observaciones);
       mascota.setUnDuenio(duenio);
       
     controlPersistencia.guardar(duenio,mascota);

         }
        
}
