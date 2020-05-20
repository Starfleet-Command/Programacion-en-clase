#lang racket

(define (greet)
(displayln "Hello There!")

)

(define (threading)
	(displayln "start main process")
	(thread (lambda () (printf "Thread 1: ~a\n" (current-thread))))
	(thread (lambda () (printf "Thread 2: ~a\n" (current-thread))))
	(thread (lambda () (printf "Thread 3: ~a\n" (current-thread))))
	(thread (lambda () (printf "Thread 4: ~a\n" (current-thread))))
    (sleep 1)
	(displayln "end main process"))


    ; Create a thread and give it a name
    (define (make-thread name) 
	(thread (lambda ()
        (let loop
        ()
		(define msg (thread-receive))
		(sleep (random 2))
        
			(cond 
			[(equal? msg 'end)
			 (printf "Thread ~a Finishing \n" name)
			]

			[(number? msg)
			 (printf "Thread ~a received a number: ~a\n"name msg)
			 (loop)
			]

			[(string? msg)
			 (printf "Thread ~a received a message: ~a\n"name msg)
			 (loop)
			]
			)
            
		
		)
		)
	)
	)

(define (main names)
    (displayln "MAIN THREAD START")
	(define data '("hello" 1 2 3 4 "bye" 'end))
    (define threads (map make-thread names))
	(for ([item data])
		(for ([thread threads])
		(thread-send thread data)
		)
	)
	(for-each thread-wait threads)
    (displayln "MAIN THREAD FINISH"))

(main '(one two three four))