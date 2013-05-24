(ns project-euler.p31)


;Coin sums
;Problem 31
;In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

;1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
;It is possible to make £2 in the following way:

;1£1 + 150p + 220p + 15p + 12p + 31p
;How many different ways can £2 be made using any number of coins?


(defn better-ways [n coins] "Good old recursion"
  (cond
    (zero? n) 1
    (empty? coins) 0
    :else
      (let [b (apply max coins)]
       (cond
         (= b n) (+ 1 (better-ways n (disj coins b))) ; when the biggest coin equal or bigger then sum, drop it from set
         (> b n) (better-ways n (disj coins b))
         :else  ; combine ways of (sum without biggest coun) and ways without biggest coin
          (+ (better-ways (- n b) coins) (better-ways n (disj coins b)))
        ))))

(time
  (println
    (better-ways 200 #{1 2 5 10 20 50 100 200})))
;=>73682

(defn new-ways [n coins] "Testing if this way work faster"
  (cond
    (zero? n) 1
    (< n 0) 0
    (empty? coins) 0
    :else
      (let [b (apply max coins)]
          (+ (new-ways (- n b) coins) (new-ways n (disj coins b))
        ))))


(time ; and almost same time here
  (println
    (new-ways 200 #{1 2 5 10 20 50 100 200})))



(defn ways [n]
  (cond
   (= n 1) 1    ; 1p
   (= n 2) 2    ; 2*1p, 2p
   (= n 3) 2    ; 3*1p, 1p+2p
   (= n 4) 3    ; 4*1p, 2*1p+2p, 2*2p
   (= n 5) 4    ; 5*1p, 3*1p+2p, 1p+2*2p, 5p
   (= n 6) 5    ; 6*1p, 4*1p+2p, 2*1p+2*2p, 3*2p, 1p+5p
   (= n 7) 6    ; 7*1p, 5*1p+2p, 3*1p+2*2p, 1p+3*2p, 2*1p+5p,  2p+5p
   (= n 8) 7    ; 8*1p, 6*1p+2p, 4*1p+2*2p, 2*1p+3*2p, 4*2p, 3*1p+5p, 1*1p+2p+5p
   (= n 9) 8    ; 9*1p, 7*1p+2p, 5*1p+2*2p, 3*2p+3*2p, 1*1p+4*2p, 4*1p+5p, 2*1p+2p+5p, 2*2p+5p
   (= n 10) 8   ; 10*1p, 8*1p+2p, 6*1p+2*2p, 4*1p+3*2p, 2*1p+4*2p, 5*2p, 5*1p+5p, 3*1p+2p+5p, 1p+2*2p+5p, 2*5p, 1*10p
  ))




