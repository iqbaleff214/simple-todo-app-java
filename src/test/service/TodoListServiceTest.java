package test.service;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        service.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        service.addTodoList("Belajar Java Dasar");
        service.addTodoList("Belajar Java OOP");
        service.addTodoList("Belajar Java Standard Classes");

        service.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        service.addTodoList("Belajar Java Dasar");
        service.addTodoList("Belajar Java OOP");
        service.addTodoList("Belajar Java Standard Classes");

        service.showTodoList();

        service.removeTodoList(5);

        service.showTodoList();
    }
}
