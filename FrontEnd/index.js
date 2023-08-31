import Task from './task.js';

let nome_task           = document.getElementById('nome-task')
let data_task           = document.getElementById('data-task')
let estado_task         = document.getElementById('estado-task')
let prioridade_task     = document.getElementById('prioridade-task')
let categoria_task      = document.getElementById('categoria-task')
let description_task    = document.getElementById('description-task')

let todo_task_container     = document.getElementsByClassName('todo-task-container')
let doing_task_container    = document.getElementsByClassName('doing-task-container')
let done_task_container     = document.getElementsByClassName('done-task-container')


let todoList = [];
let doingList = [];
let doneList = [];


document.getElementById("add-task").onclick = ()=>{
    addTaskToList(nome_task.value,description_task.value,data_task.value,estado_task.value)
    
}

function addTaskToList(nome, description, dataLimite, status) {
    const newTask = new Task(nome, description, dataLimite, status);

    switch (estado_task.value) {
        case "todo":
          alert("todo");
          break;
        case "doing":
          alert("doing");
          break;
        default:
          alert("done")
      }

    todoList.push(newTask);
  }