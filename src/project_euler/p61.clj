(ns project-euler.p61
    (:require [clojure.math.combinatorics :as combo]))


(defn figures [f]
  (->> (range)
       (map f)
       (drop-while #(> 4 (count (str %))))
       (take-while #(= 4 (count (str %))))              
       ))

(time (println    
(apply concat
(for [[f2 f3 f4 f5 f6] (combo/permutations [ 
                                               (figures (fn [n] (* n n))) 
                                               (figures (fn [n] (* n (dec (* 3 n)) 1/2 )))
                                               (figures (fn [n] (* n (dec (* 2 n)) )))
                                               (figures (fn [n] (* n (- (* 5 n) 3) 1/2)))
                                               (figures (fn [n] (* n (- (* 3 n) 2) )))
                                                  ])]
     (for [el3 (figures (fn [n] (* n (inc n) 1/2)))
           el4 (filter #(= (subs (str el3) 2) (subs (str %) 0 2))  f2) 
           el5 (filter #(= (subs (str el4) 2) (subs (str %) 0 2))   f3)  
           el6 (filter #(= (subs (str el5) 2) (subs (str %) 0 2))   f4)  
           el7 (filter #(= (subs (str el6) 2) (subs (str %) 0 2))   f5)  
           el8 (filter #(= (subs (str el7) 2) (subs (str %) 0 2))   f6) 
           :when (= (subs (str el8) 2) (subs (str el3) 0 2))
           ]
          [el3 el4 el5 el6 el7 el8]))
)))
