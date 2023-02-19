package org.algo.mak.solution.impl.bitarithmetic;

import org.algo.mak.solution.Solver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "";
        List<Solver> solvers =
                List.of(
                    new KingMovesSolver("1.Bitboard - King"),
                    new KnightMovesSolver("2.Bitboard - Knight"),
                    new RookMovesSolver("3.Bitboard - Rook")
//                    new BishopMovesSolver("3.Bitboard - Bishop")
//                    new QueenMovesSolver("3.Bitboard - Queen")

                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}