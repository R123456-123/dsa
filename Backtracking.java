/*  

-> Backtracking relies on a State Space Tree. Each node represents a state, and each edge represents a choice.
* Choose: Pick a potential option from the current state.
* Constraint Check: Is this choice valid? (Does it break any rules?)
* Recurse: If valid, move to the next level of the problem.
* Backtrack: If you hit a dead end or finish exploring a path, undo the last choice to return to the previous state and try the next option.

-> When to Use Backtracking
* Constraint satisfaction problems: When you need to build a solution step by step and must satisfy certain conditions (e.g., N-Queens, Sudoku, Rat in a Maze).
* Search problems: When the solution space is large, but invalid or infeasible branches can be pruned early.
* Multiple solutions: When you need to explore all possible valid solutions, not just one.
* Combinatorial problems: When you must generate all valid combinations, permutations, or subsets under constraints.

-> When Not to Use Backtracking
* Greedy or DP fits better: If the problem can be solved directly using a greedy strategy or dynamic programming, backtracking is overkill.
* No pruning possible: If all branches must be explored anyway (no constraints to cut early), brute force or iterative methods may be simpler.
* Large input size: Backtracking can be exponential in time. For very large inputs without strong pruning opportunities, it becomes impractical.
* Single optimal solution: If the task only needs one best solution with clear optimization criteria, algorithms like DP, greedy, or graph search may be faster.

-> The Three Pillars - To master backtracking, you must identify these three things for every problem:
* Our Choices: What are the possible moves at each step?
* Our Constraints: What rules limit our choices?
* Our Goal: What does a "finished" solution look like?

-> Performance Tricks
* Pruning: The earlier you can "kill" a bad branch, the faster your code runs. For example, in the Subset Sum problem, if your current sum 
already exceeds the target, stop exploring that path immediately.
* Symmetry Breaking: If your problem has symmetrical solutions, add a constraint to only pick one to save time.
* Forward Checking: Anticipate future failures by looking one step ahead.

*/