package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service  = new TodoListServiceImpl(repository);
        TodoListView view = new TodoListView(service);

        service.addTodoList("Belajar Java Dasar");
        service.addTodoList("Belajar Java OOP");
        service.addTodoList("Belajar Java Standard Classes");

        view.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service  = new TodoListServiceImpl(repository);
        TodoListView view = new TodoListView(service);

        view.addTodoList();

        service.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service  = new TodoListServiceImpl(repository);
        TodoListView view = new TodoListView(service);

        service.addTodoList("Belajar Java Dasar");
        service.addTodoList("Belajar Java OOP");
        service.addTodoList("Belajar Java Standard Classes");

        service.showTodoList();

        view.removeTodoList();

        service.showTodoList();
    }
}
