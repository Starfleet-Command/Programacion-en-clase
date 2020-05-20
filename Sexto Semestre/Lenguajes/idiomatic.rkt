#|
    Lambdas and other functions
|#

#lang racket

(define (get-perimeters circles)
(map (lambda (r) (* pi r 2)) circles)

)

(get-perimeters '(4 7 5))

(define (forLoop n) 
(for ([i n]) (display i))

)

(forLoop '(1 2 3 4))

(for/list ([i '(4 7 5)] #:when (> i 0)) (* i 2 pi))
