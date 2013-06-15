(ns project-euler.pr066)
;Diophantine equation



(defn cfsqrt [n] ;thanks ritrencansky
  (let [a (long (Math/sqrt n))]
    (if (= n (* a a))
      [a]
      ((fn f [q m d]
         (let [m (- (* d q) m)
               d (/ (- n (* m m)) d)]
           (cons
             q
             (if (= q (* 2 a))
               ()
               (f (long (/ (+ a m) d)) m d)))))
       a 0 1))))


(defn unpack [cf]
  (cons (first cf)  (if (empty? (rest cf)) () (cycle (rest cf))   )))


(defn converg [coll]
  (+ (first coll) (if (empty? (rest coll)) 0 (/ (converg (rest coll))))))



'(defn converge-until [f coll]
  (let [g (fn rg [heads tails]
            (if (nil? (f heads))
              (rg (conj heads (first tails)) (rest tails) )
              (f heads) ) )]
       (g  [(first coll)] (rest coll))
    ))


'(defn solve [fracs]
     (converge-until
         (fn [coll] (if (pos? (reduce + coll)) (reduce + coll)  nil))
      fracs))

'(->> (converge-until solve [0 2 3]) println)


'(if (ratio? (converg coll))
               (let [r (converg coll)
                     d (denominator  r)
                     n (numerator  r)]
                     (if (= (* d d) (inc (* n n 13)) ) [d n] false)) false)


(defn good-ratio? [r t]
  (if (ratio? r)
      (let [d (denominator  r)
            n (numerator  r)]
    (= (* n n) (inc (* d d t))))
   false))

;solution
(->>
(for [d (range 1 1001)
      :let [fs (cfsqrt d)]
      :when (> (count fs) 1)]
    (->>
      (for [n (drop 1 (range))
            :let [fc (unpack fs)
                  pf (take n fc)
                  r (converg pf)]
                  :when (good-ratio? r d)
                                  ]
            [d r n])
      first)
  )
 (sort-by (fn [[a b c]] (numerator b)))
println
time)