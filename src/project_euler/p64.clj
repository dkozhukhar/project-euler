(ns project-euler.p64)
;Odd period square roots

(defn fracount [v]
(let [b0 (->> v Math/sqrt int)]
  (if (= v (* b0 b0))
     0
     (loop [fracs '(),
            ratios '([n0 d0])
            n0 b0,
            d0 1
            limit 10]
           (let [q (quot n0 d0)
                 r (rem n0 d0)
                 p (- r b0)
                 n1 (- b0 p)
                 d1 (/ (- v (* p p)) d0 )
                 newfracs (cons q fracs)
                 newratios (cons [n1 d1] ratios)
                 ]
           (cond
            ;(neg? limit) [fracs ratios]
            (>= (.indexOf ratios [n1 d1]) 0)  (+ 1 (.indexOf ratios [n1 d1]))
            :else
              (do
                  ;(println [n0 d0])
                  (recur
                   newfracs
                   newratios
                   n1
                   d1
                   (dec limit)
               ))))))))



(->> (range 10001)
     (map fracount)
     (filter odd?)
     count
     println
     time
     )








