package es.iespuertolacruz.developers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Driver;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertolacruz.developers.api.DatosPersonales;
import es.iespuertolacruz.developers.api.Miembro;
import es.iespuertolacruz.developers.controller.MiembroController;
import es.iespuertolacruz.developers.excepcion.BbddException;
import es.iespuertolacruz.developers.excepcion.FicheroException;
import es.iespuertolacruz.developers.excepcion.MiembroException;
import es.iespuertolacruz.developers.modelo.Fichero;
import es.iespuertolacruz.developers.modelo.MiembroModelo;

public class MiembroControllerTest extends UtilidadesTest {

    
    MiembroController miembroController;
    MiembroModelo miembroModelo;

    Miembro miembro;
    Miembro miembro2;
    Miembro miembro3;
    Fichero fichero;

    @BeforeEach
    public void setUp() throws BbddException, FicheroException, SQLException {
        if (miembroController == null) {
            miembroController = new MiembroController();
        }
        if (miembroModelo == null) {
            miembroModelo = new MiembroModelo();
        }

        if (fichero == null) {
            fichero = new Fichero();
        }

        if (miembro == null) {
            miembro = crearMiembro("1000","12345678A","daniel","exposito",25);
        }
        if (miembro2 == null) {
            miembro2 = crearMiembro(null, null, null, null, 0);
        }
        if (miembro3 == null) {
            miembro3 = crearMiembro("0002", "12345678C","jonay", "exposito", 26);
        }

        
            try {
                miembroController.insertar(miembro);
                miembroController.insertar(miembro2);
       
            } catch (MiembroException e) {
               fail("Fallo al insertar miembro");
            } catch (BbddException e) {
                fail("fallo al insertar en la DB");
            }
            
           
    }

    @AfterEach
    public void after() {
        try {
            miembroController.eliminar(miembro);
            miembroController.eliminar(miembro2);
        } catch (MiembroException e) {
            fail("Error al eliminar miembro");
        } catch (BbddException e) {
            fail("Error al elimanr miembro en la DB");
        }
    }

    @Test
    public void insertartest(){
        try {
            miembroController.insertar(miembro3);
            assertEquals(miembro3, miembroController.buscar(miembro3.getUid()), "No se ha encontrado al miembro");
        } catch (MiembroException | BbddException e) {
            fail("Error al insertar miembro");
        }
    }



    @Test
    public void existeTest() {
        try {
            miembroController.validar(miembro3);
        } catch (MiembroException e) {
            fail("Se ha producido un error validando el miembro no controlado");
        }
    }

   
   
    @Test
    public void insertarFailTest() {
        try {
            try {
                miembroController.insertar(miembro);
            } catch (BbddException e) {
                fail("Error al insertar en la db");
            }
        } catch (MiembroException e) {
           assertTrue(e.getMessage().contains("ya existe"));

        }
    }
     
      
    @Test
    public void buscarTest() {
        try {
            assertEquals(miembro, miembroController.buscar(miembro.getUid()), "No se ha encontrado al miembro");
        } catch (MiembroException | BbddException e) {
            fail("Error de Miembro buscarTest");

        }
    }
    
    @Test
    public void eliminarTest() {
        try {
            
            miembroController.eliminar(miembro3);
            assertTrue(miembroController.buscar(miembro3.getUid()) == null,
                    "El miembro no se ha borrado correctamente");

        } catch (MiembroException  e) {
            fail("Fallo al eliminar miembro");
        } catch (BbddException e){
            fail("Fallo al eliminar miembro de la db");
        }
    }
 
    @Test
    public void modificarMiembroTest() {
        
        try {
            miembroController.modificar(miembro);
            

        } catch (MiembroException | BbddException e) {
            fail(e.getMessage());
        }
    }
   
     


}
