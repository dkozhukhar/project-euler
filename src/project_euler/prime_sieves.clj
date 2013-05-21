(ns project-euler.prime-sieves
  ) ; use _ instead of - in filename!

;; sieve of eratosthenes
;; borrowed from christophe grand
;; more info at
;; http://clj-me.cgrand.net/2009/07/30/everybody-loves-the-sieve-of-eratosthenes
(defn eratosthenes1 [max]
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


(defn eratosthenes2 [max] ; the latter the better
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


(defn eratosthenes3 [max]
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


(defn lazy-eratosthenes3 []
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


