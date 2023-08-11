import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable{
    public String           nome;
    public int              id;
    public String           descricao;
    public LocalDateTime    dataLimite;
    public String           estado;
    public int              prioridade;
    public String           categoria;

    public boolean          alarme = true;

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
    public void setPrioridade(int pioridade) {
        this.prioridade = pioridade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @param nome
     * @param descricao
     * @param dataLimite
     * @param estado
     * @param prioridade
     */
    public Task(String nome, String descricao, LocalDateTime dataLimite, String estado,int prioridade,String categoria){
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setDataLimite(dataLimite);
        this.setEstado(estado);
        this.setPrioridade(prioridade);
        this.setCategoria(categoria);
    }


}
