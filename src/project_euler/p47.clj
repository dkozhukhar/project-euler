(ns project-euler.p47
   (:require [project-euler.primes  :as primes])
  )


(defn s4 [n]
  (= 4 (count (set (primes/prime-factors n)))))



(time
 (println
  (ffirst
  (for [abcd (partition 4 1 (range 1 200000))
        :when (every? true? (map s4 abcd))
        ]
    abcd))))
;134043