package Items;

public class Servicio extends Item {

    public Servicio(double valorTotal, String detalle) {
        super(valorTotal, detalle);
    }

    @Override
    public double getValorTotal() {
        return super.getValorTotal();
    }

    @Override
    public void setValorTotal(double valorTotal) {
        super.setValorTotal(valorTotal);
    }

    @Override
    public String getDetalle() {
        return super.getDetalle();
    }

    @Override
    public void setDetalle(String detalle) {
        super.setDetalle(detalle);
    }

    @Override
    public boolean generaRemito() {
        return false;
    }
}
