(ns project-euler.palindromes
  )



(defn fair? [n]
  "checks number for being a palindrome
  121 is a palindrome
  435 is not
  it uses java strings
  and it is fast"
  (let [tt (str n)]
    (loop [cur-num tt]
    (let
      [len (.length cur-num)
       f (first cur-num)
       l (last cur-num)
       is-good? (= f l)
       finish? (< len 3)]
      (cond
       (not is-good?) false
       (and finish? is-good?) true
       :else
         (recur
              (subs cur-num 1 (- len 1))))))))


(def palindrome? fair?)