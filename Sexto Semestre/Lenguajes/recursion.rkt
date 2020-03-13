#lang racket

(define (multiply a b )

(if (not(zero? b))
    (+ a (multiply a (- b 1) ))
    0
)
)

(define (power a b )

(if (not(zero? b))
    (* a (power a (- b 1) ))
    1
)
)

(define (tail-multiply a b result)

(if (not(zero? b))
    (tail-multiply a (sub1 b) (+ result a))
    result
)
)

(define (mult-tail a b)
(tail-multiply a b 0)
)

(multiply 4 5)
(power 3 4)
(mult-tail 4 5)