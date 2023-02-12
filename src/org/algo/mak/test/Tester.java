package org.algo.mak.test;

import org.algo.mak.solution.Solver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Tester {

    private final List<Solver> solvers;
    private final String root;

    public Tester(List<Solver> solvers, String root) {
        this.solvers = solvers;
        this.root = root;
    }

    public void run() throws IOException {
        var stopWatch = new StopWatch();
        for (Solver solver : solvers) {
            System.out.printf("=======================START - %s==================================\n", solver.getQuizName());
            String folder = solver.getFolderName();

            var iteration = 0;

            while (true) {
                var inputFileName = Path.of(root, folder, String.format("test.%s.in", iteration));
                var outputFileName = Path.of(root, folder, String.format("test.%s.out", iteration));

                if (!Files.exists(inputFileName) || !Files.exists(outputFileName)) {
                    break;
                }

                var inputData = Files.readAllLines(inputFileName);
                var outputData = Files.readString(outputFileName).trim();

                stopWatch.start();
                var result = solver.solve(inputData);
                stopWatch.stop();

                if (outputData.equals(result)) {
                    System.out.printf("Iteration.%s - Success.Time - %s\n", iteration, stopWatch.getElapsedTime());
                } else {
                    System.out.printf("Iteration.%s - Failed. Expected: %s, Actual: %s\n",
                            iteration, outputData, result);
                }

                iteration++;
            }
            System.out.printf("=======================END   - %s==================================\n\n\n", solver.getQuizName());
        }
    }
}
