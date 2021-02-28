package com.example.tercerdesafiopractico.modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Resultado implements Parcelable {
    private Empleado empleado;
    private double salarioBase;
    private double isss;
    private double afp;
    private double renta;
    private double salarioLiquido;

    public Resultado(Empleado empleado, double salarioBase, double isss, double afp, double renta, double salarioLiquido) {
        this.empleado = empleado;
        this.salarioBase = salarioBase;
        this.isss = isss;
        this.afp = afp;
        this.renta = renta;
        this.salarioLiquido = salarioLiquido;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getIsss() {
        return isss;
    }

    public void setIsss(double isss) {
        this.isss = isss;
    }

    public double getAfp() {
        return afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public double getRenta() {
        return renta;
    }

    public void setRenta(double renta) {
        this.renta = renta;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.empleado, flags);
        dest.writeDouble(this.salarioBase);
        dest.writeDouble(this.isss);
        dest.writeDouble(this.afp);
        dest.writeDouble(this.renta);
        dest.writeDouble(this.salarioLiquido);
    }

    public void readFromParcel(Parcel source) {
        this.empleado = source.readParcelable(Empleado.class.getClassLoader());
        this.salarioBase = source.readDouble();
        this.isss = source.readDouble();
        this.afp = source.readDouble();
        this.renta = source.readDouble();
        this.salarioLiquido = source.readDouble();
    }

    public Resultado() {
    }

    protected Resultado(Parcel in) {
        this.empleado = in.readParcelable(Empleado.class.getClassLoader());
        this.salarioBase = in.readDouble();
        this.isss = in.readDouble();
        this.afp = in.readDouble();
        this.renta = in.readDouble();
        this.salarioLiquido = in.readDouble();
    }

    public static final Parcelable.Creator<Resultado> CREATOR = new Parcelable.Creator<Resultado>() {
        @Override
        public Resultado createFromParcel(Parcel source) {
            return new Resultado(source);
        }

        @Override
        public Resultado[] newArray(int size) {
            return new Resultado[size];
        }
    };
}
