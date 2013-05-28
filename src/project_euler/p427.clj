(ns project-euler.427
   (:require [clojure.math.combinatorics :as combo])
)

;n-sequences
;Problem 427
;A sequence of integers S = {si} is called an n-sequence if it has n elements and each element si satisfies 1  si  n. Thus there are nn distinct n-sequences in total. For example, the sequence S = {1, 5, 5, 10, 7, 7, 7, 2, 3, 7} is a 10-sequence.

;For any sequence S, let L(S) be the length of the longest contiguous subsequence of S with the same value. For example, for the given sequence S above, L(S) = 3, because of the three consecutive 7's.

;Let f(n) =  L(S) for all n-sequences S.

;For example, f(3) = 45, f(7) = 1403689 and f(11) = 481496895121.

;Find f(7 500 000) mod 1 000 000 009.



(defn S? [n m]
  (combo/selections (range 1 (inc m)) n))

(defn GS? [n m]
    (map
     (fn [s]
       (->> s
            (partition-by identity)))
     (S? n m)))

(defn MS? [n m]
  "Longest subsequences for n-sequence"
    (map
     (fn [s]
       (->> s
            (partition-by identity)
            (map count )
            (apply max )))
     (S? n m)))

(defn f [n]
  (apply + (MS? n n)))



(defn pow [a n]
  (if (nil? n) 1 (apply * (repeat n a))))



(defn lens [s]
  (->> s
     (partition-by identity)
     (filter #(= \k (first %)))
     (map count)
     (apply max 0)
     inc
  ))

(defn cns [s]
  (let [c (count s)
        cs ((frequencies s) \s)
        ck ((frequencies s) \k)]
  [(* 1N (inc c) (pow c cs)) (lens s)]
  ))


(defn ks [a]
  `(~(str "k" a) ~(str "s" a)))



(defn ksm [l] (flatten (map ks l)))

(time
  (println
     (->> '("")
         (iterate ksm)
         (drop 2) ;f(11) = 481496895121.
         (first)

         (map cns)
 )))



(quot (* 7500000 7500000)  1000000009)
