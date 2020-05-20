#lang racket
(define test-sem (make-semaphore 1) )
    ; Create a thread and give it a name
    (define (make-thread name) 
	(thread (lambda ()
        (let loop
        ([n 0])
		(if (= n 100) 
        (printf "Thread ~a finishing \n" name)
        (begin
        ;(semaphore-wait test-sem)
            (printf "Thread ~a got number ~a\n" name n)
        ;(semaphore-post test-sem)
            (loop (add1 n))
        )
        
        )
            
		
		)
		)
	)
	)

(define (main names)
    (displayln "MAIN THREAD START")
    (define threads (map make-thread names))
	(for-each thread-wait threads)
    (displayln "MAIN THREAD FINISH"))

(main '(one two three four five))