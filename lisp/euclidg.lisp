(defun euclidg (a b)
    (if (= a b) 
        a
        (if (> a b) 
            (euclidg b (- a b)) 
            (euclidg a (- b a))
        )
    )
)