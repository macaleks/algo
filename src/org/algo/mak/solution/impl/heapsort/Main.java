package org.algo.mak.solution.impl.heapsort;

import org.algo.mak.solution.Solver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "Sorting";
        List<Solver> solvers =
                List.of(
                    new HeapSortSolver("0.random"),
                    new HeapSortSolver("1.digits"),
                    new HeapSortSolver("2.sorted"),
                    new HeapSortSolver("3.revers")
                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}
