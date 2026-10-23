package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascota;

public class ControladoraPersistencia {
  
DuenioJpaController duenioJpa = new DuenioJpaController();
MascotaJpaController mascotaJpa = new MascotaJpaController();
    
    public void guardar(Duenio duenio, Mascota mascota) {
        
        // crear el duenio en la bd
        duenioJpa.create(duenio);
        
        // crear la mascota en la bd
        mascotaJpa.create(mascota);
    }

}
