(ns project-euler.pr076
    )

(declare way*)

(defn ways [m n]
  (cond
   (zero? n) 1
   (= 1 n) 1
   (= 1 m) 1
   (> m n) (way* n n)
   :else
      (->>
          (for [i (range 1 (min (inc m) (inc n)))]
            (way* i (- n i)))
          flatten
          (reduce +)
          )
   ))


(def way* (memoize ways))

(->>
  (ways 99 100)
  println
  time
 )