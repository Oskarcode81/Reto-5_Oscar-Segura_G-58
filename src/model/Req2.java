package model;

public class Req2 {
    private int estrato;
    private String fechaInicio;
    private int financiable;
    private double porcetaje;

    public Req2(int estrato, String fechaInicio, int financiable, double porcetaje) {
        this.estrato = estrato;
        this.fechaInicio = fechaInicio;
        this.financiable = financiable;
        this.porcetaje = porcetaje;
    }

    @Override
    public String toString() {
        return "Req2 [estrato=" + estrato +
            ", fechaInicio=" + fechaInicio +
            ", financiable=" + financiable +
            ", porcetaje=" + porcetaje + "]";
    }

}
