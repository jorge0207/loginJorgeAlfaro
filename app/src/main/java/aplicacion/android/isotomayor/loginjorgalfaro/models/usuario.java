package aplicacion.android.isotomayor.loginjorgalfaro.models;

import aplicacion.android.isotomayor.loginjorgalfaro.application.MyApplication;
import aplicacion.android.isotomayor.loginjorgalfaro.application.MyApplicationUsuario;
import io.realm.RealmObject;

public class usuario extends RealmObject {
    private int id;
    private String nombre;
    private String contraseña;

    public usuario(){}

    public usuario(String Nombre, String Contraseña) {
        id = MyApplicationUsuario.usuarioID.incrementAndGet();
        nombre = Nombre;
        contraseña = Contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
