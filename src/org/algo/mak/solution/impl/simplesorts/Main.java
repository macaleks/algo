package org.algo.mak.solution.impl.simplesorts;

import org.algo.mak.solution.Solver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "Sorting";
        List<Solver> solvers =
                List.of(
                        new BubbleSortSolver("0.random"),
                        new InsertionSortSolver("0.random"),
                        new ShellSortSolver("0.random")
                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}
