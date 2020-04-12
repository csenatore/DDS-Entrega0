package Items;

public abstract class Item {

    private double valorTotal;
    private String detalle;

    public Item(double valorTotal, String detalle) {
        this.valorTotal = valorTotal;
        this.detalle = detalle;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean generaRemito(){
        return false;
    }
}
