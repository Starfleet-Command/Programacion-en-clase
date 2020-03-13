#|
    DEFINE ALL THE FUNCTIONS
|#


#lang racket

(define (maximum a b c)
(max a b c)
)

(define (cases A)
(case A
['A (print '(es una a))]
['B (print '(es una b))]
)
)

(case (- 7 5)
[(1 2 3) "pequeño"]
[(10 11 12) "grande"]
[else "ninguna de las dos"]
)

(define (calcu sign first second)
(case sign
[("suma" "sum") (+ first second)]
[("resta") (- first second)]
[("multiplicacion") (* first second)]
[("division") (/ first second)]
[else (begin (display "ninguna de las dos\n") 0)]
)
)

(define (xFunc x) 
(cond
[(<= x -1) (+ x 2)]
[(and (<= -1 x) (< x 0)) (1)]
[(>= x 0) (+ (* -1 (* x x)) 1)]
)
)

(maximum 10 12 15)
(cases 'A)
;(calcu "tmp" 10 12)
(xFunc -3)
(xFunc -1)
(xFunc 2)
