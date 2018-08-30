package aplicacion.android.isotomayor.loginjorgalfaro.models;


import aplicacion.android.isotomayor.loginjorgalfaro.application.MyApplication;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class alumno extends RealmObject {
    @PrimaryKey
    private int id;
    private String rut;
    private String nombre;
    private int edad;
    private String direccion;
    private int sueldo;
    private String cargo;

    public alumno(){}

    public alumno(String Nombre, String Rut, int Edad, String Direccion, int Sueldo,  String Cargo) {
        id = MyApplication.alumnoID.incrementAndGet();
        rut = Rut;
        nombre = Nombre;
        edad = Edad;
        direccion = Direccion;
        sueldo = Sueldo;
        cargo = Cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
