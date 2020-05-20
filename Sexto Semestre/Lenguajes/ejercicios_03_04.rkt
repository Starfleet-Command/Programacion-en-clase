#lang racket


(define (multi-list item n)
(let loop
(
    [n n]
    [result empty]
)
    (if (zero? n)
    result
    (loop (sub1 n) (cons item result))
    )

)
)

(define (replicate data times)
(let loop
(
    [data data]
    [result empty]
)
    (if (empty? data)
    result
    (loop (cdr data) (append result (multi-list (car data) times) ))
    )

)
)

(replicate '(a b c d) 5)

(define (sizeofList list) ;Helper function to obtain the size of a list. IN: List. OUT: size (number)

(let loop
    (
        [list list]
        [size 0]
    )

    (if (empty? list)
        size
        (loop (cdr list) (+ 1 size) )
    
    )
)
)


(define (expand list)
(let loop
(
    [data list]
    [result empty]
    [expander 1]
)
    (if (empty? data)
    result
    (loop (cdr data) (append result (multi-list (car data) expander)) (+ expander 1))
    )

)
)

(expand '(1 2 3 4))

(define (insert element list)
(let loop
(
    [data list]
    [result empty]
)

(cond 
    [(empty? data)
        (append result (list element))
    ]
    [(> element (car data))
        (loop (cdr data) (append result (list(car data))) )
    ]
    [(<= element (car data))
        (append result (list element) data)
    ]
)
)
)

(insert 4 '(7 8 9))