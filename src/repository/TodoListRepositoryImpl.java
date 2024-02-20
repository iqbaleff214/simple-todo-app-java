package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    private TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    @Override
    public void add(TodoList todoList) {
        resizeIfFull();

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }

    }

    private void resizeIfFull() {
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    private boolean isFull() {
        for (TodoList datum : data) {
            if (datum == null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean remove(Integer number) {
        var index = number - 1;
        if (index < 0) {
            return false;
        } else if (index >= data.length) {
            return false;
        } else if (data[index] == null) {
            return false;
        } else {
            for (int i = index; i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }

            return true;
        }
    }
}
