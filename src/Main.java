import org.algo.mak.solution.Solver;
import org.algo.mak.solution.impl.LuckyTicketAlgoSolver;
import org.algo.mak.solution.impl.LuckyTicketRecursiveSolver;
import org.algo.mak.solution.impl.StringLengthSolver;
import org.algo.mak.test.Tester;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String root = "";
        List<Solver> solvers =
                List.of(
//                        new StringLengthSolver("0.String"),
//                        new LuckyTicketRecursiveSolver("1.Tickets"),
                        new LuckyTicketAlgoSolver("1.Tickets")
                );

        Tester tester = new Tester(solvers, root);
        tester.run();
    }
}