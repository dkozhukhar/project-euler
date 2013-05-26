(ns project-euler.utils
  )


(defn char-to-int [c]
  "converts char to integer
  example:
(char-to-int \3) => 3
  return nil if not a digit"
(let [t (int c)]
 (cond
  (< t 48) nil
  (> t 57) nil
  :else
  (- t 48))))



(defn digits [n]
  "convert number to vector of its digits"
   (map  char-to-int (vec (str n))))



(defn map2 [f coll2]
"maps function f in nested collection coll2
example:
(partition 2 1 (range 5))
=> ((0 1) (1 2) (2 3) (3 4))

(map2 inc '((0 1) (1 2) (2 3) (3 4)))
=> ((1 2) (2 3) (3 4) (4 5))"
  (map #(map f %) coll2))


(defn reduce-map [f1 f2 & coll]
  "reduce with f1 the result of mapping f2 on a collection

  (reduce-map + inc 0 1) => 3"
  (reduce f1 (map f2 coll)))


; this one comes from problem 39
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

