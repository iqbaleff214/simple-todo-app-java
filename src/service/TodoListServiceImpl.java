package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository repository) {
        this.todoListRepository = repository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = this.todoListRepository.getAll();
        for (int i = 0; i < model.length; i++) {
            TodoList todo = model[i];
            var no = i+1;

            if (todo != null) {
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
    }

    @Override
    public void removeTodoList(Integer number) {
        todoListRepository.remove(number);
    }
}
