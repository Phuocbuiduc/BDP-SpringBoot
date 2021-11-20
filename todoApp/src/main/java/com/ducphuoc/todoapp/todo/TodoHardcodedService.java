package com.ducphuoc.todoapp.todo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idCounter = 0;

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);

        if (todo == null)
            return null;

        if (todos.remove(todo)) {
            return todo;
        }

        return null;

    }
    
    public Todo saveTodo(Todo todo) {
        
        if(todo.getId()==-1 || todo.getId()==0) {
            todo.setId(++idCounter);
            todos.add(todo);
        }else {
            deleteById(todo.getId());
            todos.add(todo);
        }
            
        return todo;
    }

    private Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    static {
        todos.add(new Todo(++idCounter, "user01", "Learn Spring Boot and React", new Date(), false));
        todos.add(new Todo(++idCounter, "user02", "Learn Green Book", new Date(), true));
        todos.add(new Todo(++idCounter, "user03", "Learn SQL", new Date(), true));
        todos.add(new Todo(++idCounter, "user04", "Learn Shell Scripting", new Date(), false));
        todos.add(new Todo(++idCounter, "user05", "Learn GIT", new Date(), false));
        todos.add(new Todo(++idCounter, "user06", "Learn Java Master", new Date(), false));
        todos.add(new Todo(++idCounter, "user06", "Lear Javascript", new Date(), true));
    }

    public Todo getTodoById(long id) {
        Todo todo = findById(id);

        if (todo == null)
            return null;

         

        return todo;
    }
}
