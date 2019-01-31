// This problem was asked by Jane Street.

// cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
// For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

// Given this implementation of cons:

// def cons(a, b):
//     def pair(f):
//         return f(a, b)
//     return pair
// Implement car and cdr.


// def cons(a, b):
//     def pair(f):
//         return f(a, b)
//     return pair

// def car(f):
//     def func(a,b):
//         return a
//     return f(func)

// def cdr(f):
//     def func(a,b):
//         return b
//     return f(func)

// if __name__ == '__main__':
// 	# Read input of two numbers, separated by commas
// 	a, b = (int(n) for n in input().split(','))
// 	print(car(cons(a, b)))
// 	print(cdr(cons(a, b)))


public class Daily5{

    public static void main(String[] args){
        int param = 1;
        (param) -> System.out.println("hello");

    }
}