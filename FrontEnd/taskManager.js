import Task from './task.js';

let nome_task               = document.getElementById('nome-task');
let data_task               = document.getElementById('data-task');
let status_task             = document.getElementById('estado-task');
let prioridade_task         = document.getElementById('prioridade-task');
let categoria_task          = document.getElementById('categoria-task');
let description_task        = document.getElementById('description-task');

let todo_task_container     = document.getElementById("content-todo");
let doing_task_container    = document.getElementsByClassName('doing-task-container');
let done_task_container     = document.getElementsByClassName('done-task-container');


let todoList =  [];
let doingList = [];
let doneList =  [];

let currentID;


document.getElementById("add-task").onclick = ()=>{
    addTaskToList(  nome_task.value,
                    description_task.value,
                    data_task.value,
                    status_task.value,
                    prioridade_task.value,
                    categoria_task.value);
}

function addTaskToList( nome,
                        description,
                        dataLimite,
                        status,
                        prioridade,
                        categoria) {
    
    
    const newTask = new Task(nome,description,dataLimite,status,prioridade,categoria);
    
    checkStatusList(newTask);

    addTasksToContainer();

  }


function checkStatusList(task){
    switch (status_task.value) {
        case "todo":
            todoList.push(task);
            break;
        case "doing":
            doingList.push(task);
            break;
        default:
            doingList.push(task);
      }  
}

function addTasksToContainer(){

    const taskContainer  = document.createElement("div");
    taskContainer.classList.add("task");

    const task = todoList[todoList.length -1];
    
    setVariablesInDiv(taskContainer,task);

    taskContainer.innerHTML = createTaskText(task);

    todo_task_container.appendChild(taskContainer);

    linkToCopy();

}

function createTaskText(task){

    const text = `
    ID:         ${task.id}          <br>
    Nome:       ${task.nome}        <br>Data:       ${task.getFormatedDate()} <br>
    Status:     ${task.status}      <br>Prioridade: ${task.prioridade} <br>
    categoria:  ${task.categoria}   <br>Descrição:  ${task.description}
    `

    return text
}

function setVariablesInDiv(div,task){

    div.setAttribute("id",task.id);
    div.setAttribute("nome",task.nome);
    div.setAttribute("data",task.dataLimite);
    div.setAttribute("status",task.status);
    div.setAttribute("prioridade",task.prioridade);
    div.setAttribute("categoria",task.categoria);
    div.setAttribute("description",task.description);

}

function linkToCopy(){

    const taskInfo = document.querySelectorAll(".task");

    taskInfo.forEach(div => {
        div.addEventListener("click", () => {
            // Obter o valor do atributo de dados específico dessa div
            const id = div.getAttribute("id");
            
            sendDataToFormsOnClick( div.getAttribute("nome"),
                                    div.getAttribute("description"),
                                    div.getAttribute("data"),
                                    div.getAttribute("status"),
                                    div.getAttribute("prioridade"),
                                    div.getAttribute("categoria"))

        });
      });

}

function sendDataToFormsOnClick(
                                nome,
                                description,
                                dataLimite,
                                status,
                                prioridade,
                                categoria) {

    nome_task.value         = nome;
    data_task.value         = dataLimite;
    status_task.value       = status;
    prioridade_task.value   = prioridade;
    categoria_task.value    = categoria;
    description_task.value  = description;

}

