(ns project-euler.p39
)

;Integer right triangles
;Problem 39
;If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

;{20,48,52}, {24,45,51}, {30,40,50}

;For which value of p  1000, is the number of solutions maximised?


; h is larger then k1
; h is smaller then (k1 + k2)
; k1 is larger then k2
; k2 = p - h - k1
; k2 >=1
; k1^2+k2^2=h^2


(defn sols [p]
  (count
    (for [t '(0)
          :let [lh (quot p 3) ; h is no smaller then p/3
                uh (quot p 2)] ; h is no larger then p/2
          h (range lh (inc uh))
          k1 (range (quot h 2) h)  ; k1 is no smaller then h/2
          :let [k2 (- p h k1)]
          :when (>= h k1 k2 1)
          :when (>= (+ k1 k2) h)
          :when (= (* h h) (+ (* k1 k1) (* k2 k2)) )
          ]
          [p h k1 k2])))




; like it, copy to utils
(defn fred [g? [a0 fa0] f [a & bcd]]
  "Functional reducer
  apply f on collection, returns collection element ai with the highest value f(ai)
  g? is a binary compare function
  (fred > [0 1] inc [1 2 3 4]) ; => 4"
  (if
    (nil? a)
        a0
        (if
          (g? (f a) fa0)
            (fred g? [a (f a)] f bcd)
            (fred g? [a0 fa0]  f bcd))))


(time (apply max (map sols (range 1 1001))))


(time
(println
 (fred > [0 0] sols (range 1 1001))
  ))
; => 840