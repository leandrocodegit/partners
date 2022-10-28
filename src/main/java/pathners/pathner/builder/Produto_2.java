package pathners.pathner.builder;

public class Produto_2 {

    private Long codigo;
    private String descricao;
    private Double valor;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return  "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor;
    }
}
