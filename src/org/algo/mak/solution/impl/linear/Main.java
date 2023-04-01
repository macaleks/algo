package org.algo.mak.solution.impl.linear;

import org.algo.mak.solution.Solver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "Sorting";
        List<Solver> solvers =
                List.of(
                        new RadixSortSolver("0.random"),
                        new RadixSortSolver("1.digits"),
                        new RadixSortSolver("2.sorted"),
                        new RadixSortSolver("3.revers"),
                        new BucketSortSolver("0.random"),
                        new BucketSortSolver("1.digits"),
                        new BucketSortSolver("2.sorted"),
                        new BucketSortSolver("3.revers")
                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}
