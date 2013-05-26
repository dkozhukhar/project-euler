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

(println  (S? 4 2))


(defn GS? [n m]
    (map
     (fn [s]
       (->> s
            (partition-by identity)))
     (S? n m)))

(time (println (GS? 2 3)))

; (1)
; ---
; (1) -> (1 2)
; (1) -> (1 1)
; ---    -----
; (1) -> (1 2) -> (1 2 1)
; (1) -> (1 2) -> (1 2 2)
; (1) -> (1 2) -> (1 2 3)
;
; (1) -> (1 1) -> (1 1 1)
; (1) -> (1 1) -> (1 1 2)
; (1) -> (1 1) -> (1 1 3)
; ---    -----    -------
; (1) -> (1 2) -> (1 2 1) -> (1 2 1 1)
; (1) -> (1 2) -> (1 2 1) -> (1 2 1 2)
; (1) -> (1 2) -> (1 2 1) -> (1 2 1 3)
; (1) -> (1 2) -> (1 2 1) -> (1 2 1 4)


(defn MS? [n m]
  "Longest subsequences for n-sequence"
    (map
     (fn [s]
       (->> s
            (partition-by identity)
            (map count )
            (apply max )))
     (S? n m)))

(defn ms? [s]
  "max count for subsequences s"
       (->> s
            (partition-by identity)
            (map count )
            (apply max )))



(println (MS? 2 2))

(println (group-by identity (MS? 2 2)))

(println (frequencies (MS? 3 3)))

; f_1_u1: u_1

; f_1_u2: f_1_u1 * (u_2 - 1)  *  u_2       =  1 * 1 * 2 = 2
; f_2_u2: u_2                              =          2

; f_1_u3: f_1_u2 * (u3-1)  *  u_3              = 2 * 2 * 3            = 12
; f_2_u3: f_2_u2 * (u3-2)  *  u_3 + f_1_u2     = 2 * 1 * 3   +  2     = 8 ???
; f_3_u3: u_3                                  =                        3

(println (map #(conj % 2) (S? 1 1)))


(println  (group-by ms? (S? 3 3)))

(println  (S? 1 2))

(println (MS? 4 2))

(println (group-by identity (MS? 1 2)))

(println (frequencies (MS? 3 3)))

(let [dim 7 size 2]
  (do
    (println
       "S?" (S? dim size) "\n"
       "MS?" (MS? dim size) "\n"
       "ms?" (group-by ms? (S? dim size)) "\n"
       "freq MS?" (frequencies (MS? dim size)) "\n"
  )))


(defn unsymS1 [lvl] ;Cmv = 1
  (if (= lvl 1) 1
    (unsymS1 (dec lvl))))

(unsymS1 7)

(defn unsymS2 [mxm cmv lvl] ; cmv=1, mxmv=1
  (cond
     (= lvl 1)
       (if (= mxm 2) 1 0)
     (= cmv 1)
         (+
          (unsymS2     2         2       (dec lvl))
          (unsymS2 (max mxm 1)   1       (dec lvl)))
     (= cmv 2)
          (unsymS2    2     1          (dec lvl))
     (> cmv 2)  0 ; failed
   ))


(println (unsymS2 1 1 7))