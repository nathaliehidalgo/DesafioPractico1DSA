package com.example.tercerdesafiopractico.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Empleado implements Parcelable {
    private String nombres;
    private String apellidos;
    private int cargo;
    private int horas;

    public Empleado(String nombres, String apellidos, int cargo, int horas) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.horas = horas;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getCargo() {
        return cargo;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombres);
        dest.writeString(this.apellidos);
        dest.writeInt(this.cargo);
        dest.writeInt(this.horas);
    }

    public void readFromParcel(Parcel source) {
        this.nombres = source.readString();
        this.apellidos = source.readString();
        this.cargo = source.readInt();
        this.horas = source.readInt();
    }

    protected Empleado(Parcel in) {
        this.nombres = in.readString();
        this.apellidos = in.readString();
        this.cargo = in.readInt();
        this.horas = in.readInt();
    }

    public static final Parcelable.Creator<Empleado> CREATOR = new Parcelable.Creator<Empleado>() {
        @Override
        public Empleado createFromParcel(Parcel source) {
            return new Empleado(source);
        }

        @Override
        public Empleado[] newArray(int size) {
            return new Empleado[size];
        }
    };
}
