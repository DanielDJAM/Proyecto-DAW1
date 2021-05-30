package es.iespuertolacruz.developers.api;
import java.util.Objects;

public abstract class Usuario {
    String uid;
    String tipoUsuario;

    /**
     * Constructor de la clase Usuario
     * @param uid del usuario
     */

    public Usuario() {
    }

    

    public Usuario(String uid, String tipoUsuario) {
        this.uid = uid;
        this.tipoUsuario = tipoUsuario;
    }



    /**
     * Getters y Setters de la clase Usuario
     * 
     * @return
     */
    
    public String getUid() {
        return uid;
    }



    public void setUid(String uid) {
        this.uid = uid;
    }



    public String getTipoUsuario() {
        return tipoUsuario;
    }



    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }



    @Override
    public String toString() {
        return "Usuario [uid=" + uid + "]";
    }

   



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(uid, usuario.uid);
    }
}
