package Documentos;

public class Remito extends DocumentoComercial {

    public Remito(Integer numero) {
        this.setNumero(numero);
        this.setTipoDocumento(Tipo.REMITO);
    }
}
