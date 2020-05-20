#|
    Tests de duplicacion
|#

#lang racket

(require rackunit)
(require rackunit/text-ui)

(define (duplicate data)
(if (empty? data)
    empty
    (append
        (list (car data) (car data))
        (duplicate (cdr data))
    )
)


)



(define duplicate-tests
    (test-suite "List item duplication"
    (check-equal? (duplicate '()) '() "Empty list" )
    (check-equal? (duplicate '(1)) '(1 1) "Single element list" )
    (check-equal? (duplicate '(2 3)) '(2 2 3 3) "Double element list" )
)
)

(run-tests duplicate-tests)