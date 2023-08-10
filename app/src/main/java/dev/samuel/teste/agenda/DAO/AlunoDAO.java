package dev.samuel.teste.agenda.DAO;

import dev.samuel.teste.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }
}
