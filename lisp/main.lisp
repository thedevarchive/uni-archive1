; Recursive pow
(defun recpow (n e)
	(if (or (= n 1) (= e 0))
		1
		(* n (recpow n (- e 1)))
	)
)

; Tail-recursive pow
(defun iloop (n e p)
	(if (= e 0)
		p
		(iloop n (- e 1) (* n p))
	)
)

(defun iterpow (n e)
  (iloop n e 1)
)

; Summation of a list
(defun sigma(l)    
	(if (null l)
		0
		(+ (first l) (sigma (rest l)))   
	)   
)

; Scaling a list
(defun scale(l s)
	(if (null l)
		nil
		(cons
			(* (first l) s)
			(scale (rest l) s)
		)
	)
)