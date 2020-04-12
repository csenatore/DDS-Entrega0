package Documentos;

public abstract class DocumentoComercial {
    enum Tipo {
        REMITO,
        FACTURA
    }
    private Tipo tipoDocumento;

    private Integer numero;

    public Tipo getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipo tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
