## Task Tracker

O Task Tracker é um projeto usado para rastrear e gerenciar suas tarefas. Neste programa, você dispõe de uma interface de linha de comando simples (CLI) para rastrear o que você precisa fazer, o que você fez e o que você está trabalhando atualmente.

## Funcionalidades

- [x] Adicionar, atualizar e excluir tarefas
- [x] Marcar uma tarefa como em andamento ou feito
- [x] Listar todas as tarefas
- [x] Listar todas as tarefas que são feitas
- [x] Listar todas as tarefas que não são feitas
- [x] Listar todas as tarefas que estão em andamento

## Informações do projeto

- Feito em Java.
- Usa Picocli
- Dados salvos em JSON.
- Usa Jackson para tratar o JSON.

## Comandos

A lista de comandos e seu uso é dada abaixo:

```shell
# Adding a new task
tasktracker add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating and deleting tasks
tasktracker update 1 "Buy groceries and cook dinner"
tasktracker delete 1

# Marking a task as in progress or done
tasktracker mark-in-progress 1
tasktracker mark-done 1

# Listing all tasks
tasktracker list

# Listing tasks by status
tasktracker list done
tasktracker list todo
tasktracker list in-progress
```
