(ns project-euler.p41
     (:require
             [project-euler.primes  :as primes]
))


(defn pandigital? [& args]
  (let [s (apply str args)
        l (count s)
        c* (take l '(\1 \2 \3 \4 \5 \6 \7 \8 \9))
        ss (sort s)]
          (= ss c*)))


(println 
(apply max 
 (filter #(and (pandigital? %) (primes/prime? %)) (range 1234567 7654322))))
;7652413
