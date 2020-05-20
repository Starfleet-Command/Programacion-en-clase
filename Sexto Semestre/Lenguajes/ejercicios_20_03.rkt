#lang racket

(define (positives Datalist returnList)

(if (empty? Datalist)
    returnList
    (if (negative? (car Datalist))
    (positives (cdr Datalist) returnList)
    (positives (cdr Datalist ) (append returnList (list (car Datalist))))
    )
    
)

)

(define (entry-positives Datalist)
(positives Datalist '())
)

(entry-positives '(5 4 -2))

(define (invert-pairs PairLists RotatedLists)
(if (empty? PairLists)
RotatedLists
(invert-pairs (cdr PairLists) (append RotatedLists (list (cadar PairLists))))
)

)

(define (entry-invert Datalist)
(invert-pairs Datalist '())
)

(define (tail-invert data)
(let loop
    ([data data]
     [result empty]) 
(if (empty? data)
    result
    (loop
        (cdr data)
        (append result (list(list (cadar data))) )   
    )
)
)
)

(define (swapper data item1 item2)
(let loop
    ([data data]
     [result empty]) 
(if (empty? data)
    result
    (loop (cdr data)
        (cond 
            [(equal? (car data ) item1)
                (append result (list item2))
            ]
            [(equal? (car data ) item2)
                (append result (list item1))
            ]
            [else
                (append result (list (car data)))
            ]   
        )
    )

)
)
)
(swapper '(1 2) 1 2)


(entry-invert '( (1 2) (4 5) (7 8)))
(tail-invert  '((a 1) (b 2) (c 3)))
