(ns project-euler.p55  
  (:require             
             [project-euler.palindromes  :as polis]
             )
  )

(defn rev [n]
  (->> n
       str
       reverse
       (apply str)
       BigInteger.))


(defn Lychrel? [n1]
(loop [n n1 counter 0]
  (if (>= counter 50) true
      (let [n2 (+ n (rev n))]
           (if (polis/palindrome? n2) false
                                (recur n2 (inc counter))
                                )))))

(println (count (filter Lychrel? (range 10000)) ))
