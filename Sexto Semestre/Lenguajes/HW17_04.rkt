#|
Functions to solve the Three Problem homework
Juan Francisco Gortarez Ricardez
12/04/2020
|#

#lang racket

(define (sizeofList list) ;Helper function to obtain the size of a list.

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

(define (index-of lst ele) ;Helper function to obtain the position (starting from 0) of an element in the list. 
  (let loop 
    (
      [lst lst]
      [index 0]
    )

    (cond 
        ((empty? lst) 
        #f
        )

        ((equal? (first lst) ele) 
            index
        )
        (else 
            (loop (rest lst) (add1 index))
        )
    )
  )
)

(define (insert-at lst pos x); Helper function to insert an element in a list at a given position
  (define-values (before after) (split-at lst pos))
  (append before (cons x after))
)


(define (rotate-list rotations list) ;Function that rotates all the elements in a list by the given amount and direction
(if (empty? list)
    empty
(let loop
    (
     [rotato (modulo rotations (sizeofList list))]
     [stack list]
     [rotatedList list]
    )

    (if (zero? (sizeofList stack))
        (remove-duplicates rotatedList) ;Removes the original elements of rotatedList keeping the order done by the procedures
    
        (cond
            [(>= -1 (- (index-of list (car stack)) rotato)) ;If the element will wrap-around from the left
            (loop 
                rotato 
                (cdr stack) 
                (insert-at rotatedList (+ (sizeofList list) (- (index-of list (car stack)) rotato)) (car stack) )
            )
            ]

            [(<= (sizeofList list) (- (index-of list (car stack)) rotato)) ;If the element will wrap-around from the right
            (loop 
                rotato 
                (cdr stack) 
                (insert-at rotatedList (modulo (- (index-of list (car stack)) rotato)) (car stack)) 
            )
            ]

            [else ;If no wrap-around is needed
            (loop 
                rotato 
                (cdr stack) 
                (insert-at rotatedList (- (index-of list (car stack)) rotato) (car stack))
            )
            ] 
        )
    )


)
)
)

(define (decimal->binary number) ; Function to translate a decimal number to binary
(let loop
    (
     [data number]
     [stack empty]
    )
    (if (zero? number)
    0
    (if (> 1 data)
        (reverse stack) ;The elements were added biggest-first, and the expression must become smallest-first.
        (loop 
            (truncate (/ data 2)) ;Use the divide by two algorithm
            (append stack (list (modulo data 2)))
        )
    )
    )
)
)



(define (deep-reverse inlist) ;Function to do a deep reversal of lists, reversing even nested lists. 
(let loop
    (
     [list inlist]
     [reversed empty]
    )
    (if (empty? list)
        reversed
        (if (list? (car list))
            (loop (cdr list) (cons (deep-reverse (car list)) reversed)) ;One call handles the nested reversal while the other reverses everything outside
            (loop (cdr list) (cons (car list) reversed))
        )
    )
)
)


