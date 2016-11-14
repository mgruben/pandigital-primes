# pandigital-primes 
Find the largest pandigital prime.

An n-digit number is pandigital if that number contains the digits 1 through n exactly once, in any order.  
* Ex. `321789654` is pandigital, since it contains `1, 2, 3, 4, 5, 6, 7, 8, and 9`, and is `9` digits.

The largest pandigital prime is the largest pandigital number which is also prime.

To begin thinking about the problem, the largest n-digit pandigital numbers are shown below.
```
n = 9: 987654321
n = 8: 87654321
n = 7: 7654321
...
n = 2: 21
n = 1: 1
```

The included Java class searches permutations of these pandigital numbers in double descending order (that is, searches `n = 9` before `n = 8`, and tests `987654321` before `987654312`)

This way, the first pandigital prime which is discovered is guaranteed to be the largest pandigital prime.

This project was completed for [Project Euler - Problem 41](https://projecteuler.net/problem=41).

I recommend that this code should only be viewed _after_ you've completed your own implementation.  
If you're super stuck, take a break, take a walk, and it will come to you; good luck.
