package org.algo.mak.solution.impl.qmsorts;

import org.algo.mak.solution.Solver;
import org.algo.mak.solution.impl.simplesorts.BubbleSortSolver;
import org.algo.mak.solution.impl.simplesorts.InsertionSortSolver;
import org.algo.mak.solution.impl.simplesorts.ShellSortSolver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "Sorting";
        List<Solver> solvers =
                List.of(
                        new QuickSortSolver("0.random"),
                        new QuickSortSolver("1.digits"),
                        new QuickSortSolver("2.sorted"),
                        new QuickSortSolver("3.revers"),
                        new MergeSortSolver("0.random"),
                        new MergeSortSolver("1.digits"),
                        new MergeSortSolver("2.sorted"),
                        new MergeSortSolver("3.revers")
                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}
