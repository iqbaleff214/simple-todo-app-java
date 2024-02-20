package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    final private TodoListService service;

    public TodoListView(TodoListService service) {
        this.service = service;
    }

    public void showTodoList() {
        label:
        while (true) {
            System.out.println("~ TODO LIST ~");
            service.showTodoList();

            System.out.println("~ MENU ~");
            System.out.println("1. New");
            System.out.println("2. Remove");
            System.out.println("0. Exit");

            var input = InputUtil.input("Choose menu");

            switch (input) {
                case "1":
                    addTodoList();
                    break;
                case "2":
                    removeTodoList();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    break label;
                default:
                    System.out.println("Not available");
                    break;
            }
        }
    }

    public void addTodoList() {
        System.out.println("~ NEW ~");

        String data = InputUtil.input("New Todo [0 to cancel]");

        if (!data.equals("0")) {
            service.addTodoList(data);
        }
    }

    public void removeTodoList() {
        System.out.println("~ REMOVE ~");

        String data = InputUtil.input("Todo Number [0 to cancel]");

        if (!data.equals("0")) {
            service.removeTodoList(Integer.valueOf(data));
        }
    }

}
