class Task {
    constructor(nome, description, dataLimite,status) {
      this.id = Task.generateId();
      this.nome = nome;
      this.description = description;
      this.dataLimite = dataLimite;
      this.status = status;
    }
  
    static generateId() {
      return Math.floor(Math.random() * 1000); // Gera um ID aleatório
    }
  
    setNome(nome){
        this.nome = nome; 
    }
    setDescription(desc){
        this.description = desc
    }
    setDatalimite(data){
        this.dataLimite = data;
    }
    setStatus(status){
        this.status = status
    }

  
  }

  export default Task;

  