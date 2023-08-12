# TodoApp-ZG-Desafio

Programa escrito em **Java** para exercitar conhecimentos obtidos durante o AceleraZG. A organização do projeto pode ser encontrado no link: https://trello.com/invite/b/MYgvfaGh/ATTIc85e632c8e56150d6589daa91c0b1102A7CF1DDC/zg-todo-app

### Requisitos:
- java 20.0.1
 
### Como usar:

- Entre na pasta ToDoDesafio/src
- Compile todos os arquivos .java (``*.java`` para compliar tudo de uma vez)
- Rode o arquivo Main.java

### Como funciona?

O programa é formado por estes elementos:
**Canvas**: É onde estão guardadas todas as tasks dentro de um atrbiuto chamado _task list_. Essa classe é a ponte entre a interface de usuário (usando o terminal) e a classe _TerminalUI_.

**Taks**: Essa é a classe onde estão armazenados as informações das tarefa do usuário. Possui atributos como _nomeTask_,_prioridade_,_categoria_ etc ...

**TerminalUI**: É nessa classe que é feita a interação com usuário. É nela que está alocado as perguntas que serão feitas ao usuário para preencher as _tasks_, é nela também que está o menu de ecolha.

**Alarme**: É nessa classe que está o loop que verifica se a Task está com o alarme abilitado e se o tempo da _data limite_ já passou.

**SaveSystem**: É a classe responsável por salvar de forma **local** o objeto Canvas (serialização). O save ficara no arquivo chamado _canvas.save_.


### Amostra de como ficou:

<img width="355" alt="image" src="https://github.com/VictorCalebeIFG/TodoApp-ZG-Desafio/assets/84258178/426c4a59-0588-47b8-b561-e739adb2632b">

