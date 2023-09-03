import Task from './task.js';
import gsheetsDataBase from './googleSheetsDataBase.js'

const url = "https://script.google.com/macros/s/AKfycbwgEa8EfcuPaQvyrxcMmI8slFBBdDcmu3D5_wh9BFWMSoaGTupoykVqk7XjT9KszPXxow/exec"
const sheetName = "folderdata"

const dataBase = new gsheetsDataBase(url,sheetName)

dataBase.getData().then(data => {
    //console.log(data);
  })


let nome_task               = document.getElementById('nome-task');
let data_task               = document.getElementById('data-task');
let status_task             = document.getElementById('estado-task');
let prioridade_task         = document.getElementById('prioridade-task');
let categoria_task          = document.getElementById('categoria-task');
let description_task        = document.getElementById('description-task');

let todoList =  [];
let doingList = [];
let doneList =  [];

const taskListDict = {
    "todo":todoList,
    "doing":doingList,
    "done":doneList
}

let currentID;

const taskContainerDivs = {
    "todo":document.getElementById("content-todo"),
    "doing":document.getElementById("content-doing"),
    "done":document.getElementById("content-done")
}


/*
*ON CLICK DO BOTÃO "ADD" - É AQUI QUE SERÁ ADICIONADO A TASK NA RESPECTIVA LISTA (DE ACORDO COM STATUS)
*/
document.getElementById("add-task").onclick = addTask

function addTask(startID=false){
    addTaskToList(
        nome_task.value,
        description_task.value,
        data_task.value,
        status_task.value,
        prioridade_task.value,
        categoria_task.value,
        startID = startID);
}

/**
 * FUNÇÃO ADD TASK - RECEBE OS PARAMETROS DA CLASSE E CRIA UMA INSTÂNCIA DA TASK E COLOCA NA RESPECTIVA STATUSLIST.
 */

function addTaskToList( nome,
                        description,
                        dataLimite,
                        status,
                        prioridade,
                        categoria,
                        startID = false) {
    
    
    const newTask = new Task(nome,description,dataLimite,status,prioridade,categoria);
    if(startID ==true){newTask.id = currentID};

    checkStatusList(newTask);

    addTasksToContainer();

    return newTask

  }

/**
 * VERIFICAR QUAL DAS 3 STATUSLIST DEVE SER COLOCADO A TASK.
 */

function checkStatusList(task){
    switch (status_task.value) {
        case "todo":
            todoList.push(task);
            todoList.sort((taks1,task2) => task2.prioridade - taks1.prioridade)
            break;
        case "doing":
            doingList.push(task);
            doingList.sort((taks1,task2) => task2.prioridade - taks1.prioridade)
            break;
        default:
            doneList.push(task);
            doneList.sort((taks1,task2) => task2.prioridade - taks1.prioridade)
      }  
}

/**
 * RETORNA ULTIMA TASK DA RESPECTIVA STATUSLIST.
 */

function getLastTaskOnListStatus(){
    switch (status_task.value) {
        case "todo":
            return todoList[todoList.length -1];
        case "doing":
            return doingList[doingList.length -1];
        default:
            return doneList[doneList.length -1];
      }  

}

/**
 * RETORNA A LISTA DA RESPECTIVA STATUSLIST.
 */

function getListOnStatus(){

    switch (status_task.value) {
        case "todo":
            return todoList;
        case "doing":
            return doingList;
        default:
            return doneList;
      }  

}

/**
 * ADICIONA OS ELEMENTOS HTML PARA CADA TASK
 */
function addTasksToContainer(){

    ['todo','done','doing'].forEach(status =>{
        // Limpando divs
        taskContainerDivs[status].innerHTML = '';
    
        taskListDict[status].forEach(task =>{

            const taskContent  = document.createElement("div");
            taskContent.classList.add("task");
    
            const button            = document.createElement('button');
            button.textContent      = "Selecionar"
    
            taskContent.innerHTML = createTaskText(task);
            setVariablesInDiv(taskContent,task);
    
            const div = taskContainerDivs[status];
    
            div.appendChild(taskContent);
    
            taskContent.appendChild(button)
    
            linkToSelectionButton();
    
        })
    
    })



    


    

}

/**
 * RETRONA O TEXTO PARA O INNERHTML DA DIV DA TASK.
 */
function createTaskText(task){

    const text = `
    ID:         ${task.id}          <br>
    Nome:       ${task.nome}        <br>Data:       ${task.getFormatedDate()} <br>
    Status:     ${task.status}      <br>Prioridade: ${task.prioridade} <br>
    categoria:  ${task.categoria}   <br>Descrição:  ${task.description} <br>
    `

    return text
}

/**
 * ADICIONA OS MESMOS ATRIBUTOS DA TASK AOS ATRIBUTOS DA DIV.
 * (ISSO É FEITO PARA QUE EU POSSA OBTER OS DADOS DA TASK
 * AO CLICAR NO BOTÃO "SELECIONAR")
 */
function setVariablesInDiv(div,task){

    div.setAttribute("id",task.id);
    div.setAttribute("nome",task.nome);
    div.setAttribute("data",task.dataLimite);
    div.setAttribute("status",task.status);
    div.setAttribute("prioridade",task.prioridade);
    div.setAttribute("categoria",task.categoria);
    div.setAttribute("description",task.description);

}

/**
 * FUNÇÃO RESPONSÁVEL PELA LÓGICA DE OBTER OS DADOS DA TASK E PASSAR PARA O FORMS
 * PARA A DEKETAR A TASK OU EDITAR.
 */

function linkToSelectionButton(){

    const taskInfo = document.querySelectorAll(".task");

    taskInfo.forEach(div => {
        div.addEventListener("click", () => {
            // Obter o valor do atributo de dados específico dessa div
            currentID = div.getAttribute("id");
            
            sendDataToFormsOnClick( div.getAttribute("nome"),
                                    div.getAttribute("description"),
                                    div.getAttribute("data"),
                                    div.getAttribute("status"),
                                    div.getAttribute("prioridade"),
                                    div.getAttribute("categoria"))

        });
      });

}

/**
 * ENVIA DADOS DA TASK PARA O FORMS.
 */

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

/**
 * BOTÃO DELETAR TASK
 */

document.getElementById("delete-task").onclick = deleteTask

function deleteTask(){

    if(currentID){
        ['todo','doing','done'].forEach(function(status, indice){
            deleteTaskFromList(taskListDict[status])
        });
    }

    deleteTaskFromHTML();

    ['todo','doing','done'].forEach(function(status, indice){
        console.log(taskListDict[status])
    });

}


/**
 * DELETA TASK DA RESPECTIVA STATUSLIST.
 */
function deleteTaskFromList(lista){

    lista.forEach(function(task, indice) {
        if (task.id == currentID){
            lista.splice(indice, 1); 
        }
    });

}

/**
 * DELETA TASK DO HTML
 */

function deleteTaskFromHTML(){
    
    const htmlTaskElement = document.getElementById(currentID);

    htmlTaskElement.remove();

}

document.getElementById("edit-task").onclick = editTask

function editTask(){
    deleteTask()
    addTask(true)

}



