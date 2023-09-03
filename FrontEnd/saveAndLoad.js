import gsheetsDataBase from "./googleSheetsDataBase.js";
import Task from "./task.js";

const defaulturl = "https://script.google.com/macros/s/AKfycbwW_yZBSqoyN4zJRQsr3IDqnqQg16tNksLXuDR8y3SrxbVOXYxN_A5nEuYPfmgGJIIdwA/exec"
const defaultsheetName = "folderdata"



class saveAndLoad{
    
    constructor(url = defaulturl,sheetName = defaultsheetName){
        this.dataBase = new gsheetsDataBase(url,sheetName);
    }
    
    saveList(list){
        list.forEach(element => {
            this.dataBase.appendData(element.getAtributos());
        });
    }

    deleteAll(){
        this.dataBase.deleteAlldata();
    }

    getData(){
        
        var todo = []
        var doing = []
        var done = []
        
        this.dataBase.getData().forEach(element => {
            var task = new Task(element[1],element[2],element[3],element[4],element[5],element[6]);
            task.id = element[0];
            
            if (element[4]=="todo"){
                todo.push(task)    
            }
            if (element[4]=="doing"){
                doing.push(task)    
            }
            if (element[4]=="done"){
                done.push(task)
            }
        })

        return [todo,doing,done]
    }
}

export default saveAndLoad