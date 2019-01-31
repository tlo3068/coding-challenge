# cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
# For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

# Given this implementation of cons:

# def cons(a, b):
#     def pair(f):
#         return f(a, b)
#     return pair
# Implement car and cdr.

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

def car(f):
    def first(a,b):
        return a
    return f(first)

def cdr(f):
    def second(a,b):
        return b
    return f(second)


if __name__ == '__main__':
	# Read input of two numbers, separated by commas
	a, b = (int(n) for n in input().split(','))
	print(car(cons(a, b)))
	print(cdr(cons(a, b)))


# car(cons(a,b))

# This runs car() with a function (cons(a,b)) as a parameter
# this then returns cons(a,b)(foo),
# cons(a,b)(foo) is a function that takes parameteres a,b returns a function which is then run with parameter foo
# cons(a,b) runs giving us a FUNCTION pair that takes in a parameter function (f) and returns the function run with f(a,b)
# In other words f => f(a,b)
# This leaves us with foo(a,b), since we input in the function foo, and it will return us the function with the paramaters, a,b
# pair basically just runs the function inside with the parameters (a,b)
# this runs foo(a,b) which returns a