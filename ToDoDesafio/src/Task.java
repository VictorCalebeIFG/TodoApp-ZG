import java.time.LocalDateTime;

public class Task {
    public String nome;
    public int id;
    public String descricao;
    public LocalDateTime dataLimite;
    public String estado;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    /**
     * @param nome
     * @param descricao
     * @param dataLimite
     * @param estado
     */
    public Task(String nome, String descricao, LocalDateTime dataLimite, String estado){
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setDataLimite(dataLimite);
        this.setEstado(estado);
    }


}
