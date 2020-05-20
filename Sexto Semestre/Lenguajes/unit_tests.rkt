#lang racket
(require rackunit)
(require rackunit/text-ui)

;(check-equal? 1 1.0 "not equal")

(test-begin (check-equal? 1 1 "not equal")
;Para hacer pruebas puedes meterte a un archivo con enter! y luego hacer (load)
)

(test-case "Pruebas" (check-equal? 1 1 "not equal")
;Para hacer pruebas puedes meterte a un archivo con enter! y luego hacer (load)
)

(define tests 
(test-suite "Pruebas" 
(check-equal? 1 2 "not equal")
)
)

(run-tests tests)