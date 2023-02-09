package org.algo.mak.solution.impl;

import org.algo.mak.solution.Solver;

import java.util.List;

public class StringLengthSolver extends Solver {
    public StringLengthSolver(String folder) {
        super(folder);
    }

    @Override
    public String solve(List<String> list) {
        String line = list.get(0);
        return String.valueOf(line.length());
    }
}
