(ns project-euler.primes

  )

(import 'java.util.Vector)

;(import 'math.numeric-tower)


; usege
;   (:require [project-euler.primes  :as primes])



(defn possible-primes-diapozone [n]
  (range 2 (inc (Math/floor (Math/sqrt n)))))



;; tests n for being a prime
;; borrowed somewhere
(defn prime? [n]
  "checks n for being a prime
  primes are 2,3,5,7 ..."
  (cond
   (<= n 1) false
   (= n 2) true
   (= n 3) true
   :else
  (let
    [possible-divisors (vec (possible-primes-diapozone n))
    last-divisor-position (dec (count possible-divisors))]
      (loop [divisor-position 0]
        (let
           [current-divisor
              (nth possible-divisors
                        divisor-position) ]
            (cond
               (= (rem n current-divisor) 0) false
               (= divisor-position last-divisor-position) true
               :else
                 (recur (inc divisor-position))))))))


(defn trialPrime [n]
  "tests n for being a prime by trial division"
  (->> n
       Math/sqrt
       Math/floor
       inc
       (range 2)
       (map #(mod n %))
       (every? pos?)
       ))





(defn primes-range [& args]
  "filters all primes in a (range [& args])"
  (filter prime? (apply range args)))


(defn evenly-divisible? [a b]
  "is a divisible evenly i.e. without reminder by b?"
  (= 0
    (rem a b)))

(defn every-evenly-divisible? [a b]
  "is a divisible evenly i.e. without reminder by b, where b is a collection?"
  (every? #(evenly-divisible? a %) b))


(defn max-divisor [n] (Math/floor (Math/sqrt n)))



(defn prime-factors [n]
  (loop
    [current-factor 2 current-n n divisors ()]
    (cond
       (> current-factor (max-divisor current-n))
                (cons (/ n (apply * divisors))  divisors)
       (= (rem current-n current-factor) 0)
                (recur current-factor
                       (/ current-n current-factor)
                       (cons current-factor divisors) )
       :else
                (recur (inc current-factor)
                       current-n
                       divisors))))



;; calculates primes below max
;; borrowed from christophe grand
;; more info at
;; http://clj-me.cgrand.net/2009/07/30/everybody-loves-the-sieve-of-eratosthenes

;; this sieves copyed to prime-sieves

(defn primes [max]
  (let [enqueue (fn [sieve n factor]
                  (let [m (+ n factor)]
                    (assoc sieve m
                      (conj (sieve m) factor))))
        next-sieve (fn [sieve candidate]
                     (if-let [factors (sieve candidate)]
                       (reduce #(enqueue %1 candidate %2)
                         (dissoc sieve candidate)
                         factors)
                       (enqueue sieve candidate candidate)))]
    (apply concat (vals (reduce next-sieve {} (range 2 max))))))


(defn primes2 [max] ; the latter the better
  (let [enqueue (fn [sieve n factor]
                  (let [m (+ n factor)]
                    (if (sieve m)
                      (recur sieve m factor)
                      (assoc sieve m factor))))
        next-sieve (fn [sieve candidate]
                     (if-let [factor (sieve candidate)]
                       (-> sieve
                         (dissoc candidate)
                         (enqueue candidate factor))
                       (enqueue sieve candidate candidate)))]
    (vals (reduce next-sieve {} (range 2 max)))))


(defn primes3 [max]
  (let [enqueue (fn [sieve n factor]
                  (let [m (+ n (+ factor factor))]
                    (if (sieve m)
                      (recur sieve m factor)
                      (assoc sieve m factor))))
        next-sieve (fn [sieve candidate]
                     (if-let [factor (sieve candidate)]
                       (-> sieve
                         (dissoc candidate)
                         (enqueue candidate factor))
                       (enqueue sieve candidate candidate)))]
    (cons 2 (vals (reduce next-sieve {} (range 3 max 2))))))


(defn lazy-primes3 []
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve candidate]
            (if-let [step (sieve candidate)]
              (-> sieve
                (dissoc candidate)
                (enqueue candidate step))
              (enqueue sieve candidate (+ candidate candidate))))
          (next-primes [sieve candidate]
            (if (sieve candidate)
              (recur (next-sieve sieve candidate) (+ candidate 2))
              (cons candidate
                (lazy-seq (next-primes (next-sieve sieve candidate)
                            (+ candidate 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))




(defn proper-divisors
    [n]
  (cons 1 ; 1 is a proper divisor too
    (apply concat
     (for [d (range 2 (inc (max-divisor n)))
           :when (= 0 (rem n d))]
       (if (= d (quot n d)) `(~d) `(~d ~(quot n d))) ; check to remove dublicates if d*d=n
       ))))










