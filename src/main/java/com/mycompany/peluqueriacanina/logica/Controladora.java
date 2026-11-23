package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public List<Mascota> traerMascotas() {

      return controlPersistencia.traerMascotas();
    }

    public void borrarMascota(int numCliente) {
          controlPersistencia.borrarMascota(numCliente);
    }

    public Mascota traerMascotas(int numCliente) {

     return controlPersistencia.traerMascota(numCliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, String observaciones, String alergico, String atencionEspecial, String nombreDuenio, String celDuenio) {

       masco.setNombre(nombreMascota);
       masco.setRaza(raza);
       masco.setColor(color);
       masco.setObservaciones(observaciones);
       masco.setAlergico(alergico);
       masco.setAtencionEspecial(atencionEspecial);
        
       // Modifico la mascota
       controlPersistencia.modificarMascota(masco);
        
       // Seteo los nuevos valores del nuevo dueño
       Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getIdDuenio());
       dueno.setCelDuenio(celDuenio);
       dueno.setNombre(nombreDuenio);
       
       // LLamo al modificar dueño
       this.modificarDuenio(dueno);

    }

    private Duenio buscarDuenio(int idDuenio) {

      return controlPersistencia.traerDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio dueno) {
 
      controlPersistencia.modificarDuenio(dueno);       
    }
        
}
