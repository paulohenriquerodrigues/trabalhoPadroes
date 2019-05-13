package Command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

    private List<Command> todos = new ArrayList<>();

    public void adicionar(Command comm) {
        todos.add(comm);
    }

    public void execute( Command comm) {

        comm.execute();
        todos.add(comm);

    }

    public void imprimir() {

        System.out.println("Log :");
        for (Command comm : todos) {
            System.out.println(" " + comm);
        }

    }

}
