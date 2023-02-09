package org.algo.mak.solution;

import java.util.List;

public abstract class Solver {

    private final String folder;
    private final String quizName;

    public Solver(String folder) {
        this.folder = folder;
        this.quizName = getClass().getSimpleName();
    }

    public String getFolderName() {
        return folder;
    }

    public String getQuizName() {
        return quizName;
    }

    public abstract String solve(List<String> list);

}
