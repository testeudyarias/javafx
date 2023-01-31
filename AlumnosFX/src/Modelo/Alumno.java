/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author developer
 */
public class Alumno  implements Comparable<Alumno>{
    private String dni ;
    private String siglaModuloMatriculado ;
    private double nota  ;
    private String provincia;

    public Alumno(String dni, String siglaModuloMatriculado, double nota, String provincia) {
        this.dni = dni;
        this.siglaModuloMatriculado = siglaModuloMatriculado;
        this.nota = nota;
        this.provincia = provincia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSiglaModuloMatriculado() {
        return siglaModuloMatriculado;
    }

    public void setSiglaModuloMatriculado(String siglaModuloMatriculado) {
        this.siglaModuloMatriculado = siglaModuloMatriculado;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int compareTo(Alumno o) {
        return dni.compareTo(o.getDni());
    }
    
}
