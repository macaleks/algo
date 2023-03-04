package org.algo.mak.solution.impl.algomath;

import org.algo.mak.solution.Solver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "";
        List<Solver> solvers =
                List.of(
                        new AlgoMath010Solver("3.Power"),
                        new AlgoMath020Solver("4.Fibo"),
                        new AlgoMath021Solver("4.Fibo"),
                        new AlgoMath030Solver("5.Primes"),
                        new AlgoMath110Solver("3.Power"),
                        new AlgoMath120Solver("3.Power"),
                        new AlgoMath130Solver("4.Fibo"),
                        new AlgoMath140Solver("4.Fibo"),
                        new AlgoMath150Solver("5.Primes")

                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}