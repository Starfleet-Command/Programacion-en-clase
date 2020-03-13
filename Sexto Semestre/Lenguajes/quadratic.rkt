#|
    Program to calculate the roots of a quadratic function
    Juan Francisco Gortarez
    29/02/2020
|#

#lang racket

(define (cInterno a b c) ;Helper function to simplify syntax
    (sqrt(- (* b b) (* 4 a c) ) )
)

(define (chicharronera a b c)
  (if (zero? a)  (/ (* -1 c) b) ;if A is zero use alternate form
    
    (let* ([x (/ (+ (* -1 b)  (cInterno a b c)) (* 2 a)) ]
           [y (/ (- (* -1 b)  (cInterno a b c)) (* 2 a)) ]
          )
    (list x y))

    ) ;Do both forms of the formulae if A is not zero
)

(chicharronera 1 4 -5) ;Example call for a!=0. Should return (1, -5)
(chicharronera 0 4 -5) ;Example call for a=0. Should return 5/4