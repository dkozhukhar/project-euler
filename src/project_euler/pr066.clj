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



(defn converge-until [f coll]
  (let [g (fn [heads tails] (if (f heads) (f heads) (g (conj heads (first tails)) (rest tails) ) ) )]
   (g  [(first coll)] (rest coll))))


(->> 13
     cfsqrt
     unpack
     (take 100)
     converg
     println
     )

(defn solve [fracs]
     (converge-until
         (fn [coll] (> (first coll) 0))
      fracs))

(converge-until solve [0 2 3])


(if (ratio? (converg coll))
               (let [r (converg coll)
                     d (denominator  r)
                     n (numerator  r)]
                     (if (= (* d d) (inc (* n n 13)) ) [d n] false)) false))



(->> 13
     cfsqrt
     unpack
     (take 100)

     println
     )

