(ns project-euler.pr078)
;http://mathworld.wolfram.com/PartitionFunctionP.html

(declare p*)

(defn p [n]
  (cond
   (neg? n) 0
   (= n 0) 1
   (= n 1) 1
   (= n 2) 2
   (= n 3) 3
   (= n 4) 5
   :else
       (mod
         (->>
          (for [k (range 1 (Math/sqrt n))]
             (*
                     (if (odd? k) 1 -1)
                     (+
                       (p* (- n (* 1/2 k (dec (* 3 k)) )))
                       (p* (- n (* 1/2 k (inc (* 3 k)) ))))
                     ))
          (reduce +)
          )
        1000000)
   ))




(def p* (memoize p))



(->>
  (range 1 100000)
  (filter #(= 124 (mod % 125))) ;thanks ramanujan
  (filter #(zero? (p %)))
  first
  println
  time
 )

