package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodoRepository todorepos;

    @Transactional
    @Override
    public Todo markComplete(Todo todo,
                             long todoid)
    {
        Todo currenttodo = todorepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found!"));

        if (todo.getDescription() != null)
        {
            currenttodo.setDescription(todo.getDescription());
        }

        if (todo.isCompleted() == false)
        {
            currenttodo.setCompleted(true);
        }

        return todorepos.save(currenttodo);
    }
}
