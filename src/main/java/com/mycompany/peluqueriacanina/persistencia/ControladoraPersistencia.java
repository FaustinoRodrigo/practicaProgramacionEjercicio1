package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladoraPersistencia {

  
DuenioJpaController duenioJpa = new DuenioJpaController();
MascotaJpaController mascotaJpa = new MascotaJpaController();
    
    public void guardar(Duenio duenio, Mascota mascota) {
        
        // crear el duenio en la bd
        duenioJpa.create(duenio);
        
        // crear la mascota en la bd
        mascotaJpa.create(mascota);
    }

    public List<Mascota> traerMascotas() {

       return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int numCliente) {
    try {
        mascotaJpa.destroy(numCliente);
    } catch (NonexistentEntityException ex) {
        System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
    }

    public Mascota traerMascota(int numCliente) {
      return mascotaJpa.findMascota(numCliente);
    }

    public void modificarMascota(Mascota masco) {

    try {
        mascotaJpa.edit(masco);
    } catch (Exception ex) {
        System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
    }

    public Duenio traerDuenio(int idDuenio) {

     return duenioJpa.findIdDuenio(idDuenio);
    }

    public void modificarDuenio(Duenio dueno) {

    try {
        duenioJpa.edit(dueno);
    } catch (Exception ex) {
        System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
    }
}
