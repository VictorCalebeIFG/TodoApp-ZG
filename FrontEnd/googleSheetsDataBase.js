class gsheetsDataBase{

    constructor(gsheeturl,worksheetname){
        this.gsheeturl = gsheeturl
        this.worksheetname = worksheetname
    }

    getData(){
        fetch(this.gsheeturl+"?action=getdata").then(response => {
            if (!response.ok) {
                throw new Error('Erro na solicitação: ' + response.status);
            }
        return response.json();
        })
    }

    appendData(data){
        fetch(this.gsheeturl+"?action=append&data="+"[" + data.join(",") + "]")
    }

    deleteDataRow(row){
        fetch(this.gsheeturl+"?action=delete&data="+String(row))
    }
}