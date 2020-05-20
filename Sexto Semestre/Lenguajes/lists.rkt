#lang racket

(list 3 4 8 6)

(define data (list 3 4 8 6))
data
(first data)
(car data)
(cdr data)
(define data2 '( (1 2 3) (4 5 6) (7 8 9)))
(caar data2)
(cadr data2)
(list-ref data2 1)
(cons 111 data)
(append '(111) data)
(cons data data2)
(member 4 data)
(define (plus a)
(+ 1 a)
)
(map plus data)

(define (len lst)
    (if (empty? lst)
    0
    (+ 1 (len (cdr lst)))
    )
)

(define (len-tail lst count)
    (if (empty? lst)
    count
    (len-tail (cdr lst) (+ count 1))
    )

)

(define (entry-len-tail lst)
    (len-tail lst 0)

)

(len data)
(entry-len-tail data)