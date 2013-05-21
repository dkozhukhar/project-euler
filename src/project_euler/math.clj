(ns project-euler.math
  )

;
(defn reduce+map [f & coll]
  "sums the result of mapping  f on a collection

  (reduce+map inc -1 1)
  => 2"
  (reduce + (map f coll)))


(defn pow2 [x]
  "square of x
  (pow2 3) => 9"

  (* x x))

(defn signed-pow2 [x]
  "square of x if x positiv
  negated square of x if x negative

  (signed-pow2 -2)
  => -4
  "
  (cond
   (= 0 x)  0
   (neg? x) (- (* x x))
   :else
     (* x x)))


(defn sum-of-squares [& coll]
  "(sum-of-squares 1 2)
  => 5"
  (reduce + (map pow2 coll)))





(defn square-of-the-sums [& coll]
  "(square-of-the-sums 1 2)
  => 9"
  (pow2 (apply + coll)))



(def facts (reductions * (iterate inc 1))) ;factorial integer base



;; A lazy-seq of Fibonacci numbers (fn = fn-1 + fn-2)
;; The producer function takes exactly two parameters
;; (because we need the last 2 elements to produce a new one)
(defn fib [a b] (cons a (lazy-seq (fib b (+ b a)))))

;user=> (take 5 (fib 1 1))
;(1 1 2 3 5)



(defn collatz-seq [n]
(let
   [collatz
     (fn [n]
       (if
        (even? n) (/ n 2)
        (inc (* 3 n))))]
  (if
   (= 1 n) '(1)
   (cons n (lazy-seq (collatz-seq (collatz n)))))))


(time (count (collatz-seq 837799)))