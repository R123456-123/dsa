//recursion -> `a function that calls itself`
public class Recursion {
    
}

// The process in which a function calls itself directly or indirectly is called recursion and the corresponding function is called a recursive function.

// A recursive algorithm takes one step toward solution and then recursively call itself to further move.
// The algorithm stops once we reach the solution.
// Since called function may further call itself, this process might continue forever. So it is essential to
// provide a base case to terminate this recursion process.

// Steps to Implement Recursion
// Step1 - Define a base case: Identify the simplest (or base) case for which the solution is known or trivial.
// This is the stopping condition for the recursion, as it prevents the function from infinitely calling itself.
// Step2 - Define a recursive case: Define the problem in terms of smaller subproblems. Break the problem down 
// into smaller versions of itself, and call the function recursively to solve each subproblem.
// Step3 - Ensure the recursion terminates: Make sure that the recursive function eventually reaches the base case, and does not enter an infinite loop.
// Step4 - Combine the solutions: Combine the solutions of the subproblems to solve the original problem.

//A function is called direct recursive if it calls itself directly during its execution. In other words, 
// the function makes a recursive call to itself within its own body.

//An indirect recursive function is one that calls another function, and that other function, in turn, calls the
// original function either directly or through other functions. This creates a chain of recursive calls involving
// multiple functions, as opposed to direct recursion, where a function calls itself.

//Tail recursion is defined as a recursive function in which the recursive call is the last statement that is
// executed by the function. So basically nothing is left to execute after the recursion call.
//The tail recursive functions are considered better than non-tail recursive functions as tail-recursion can be optimized by the compiler. 
// Compilers usually execute recursive procedures by using a stack. This stack consists of all the pertinent
// information, including the parameter values, for each recursive call. When a procedure is called, its information 
// is pushed onto a stack, and when the function terminates the information is popped out of the stack. Thus for the 
// non-tail-recursive functions, the stack depth (maximum amount of stack space used at any time during compilation) is more. 